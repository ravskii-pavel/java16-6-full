package com.levelup.dao;

import com.levelup.entity.Entity;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by java on 28.02.2017.
 */
public abstract class AbstractJSONDAO<T extends Entity> extends AbstractFileDAO<T> {

    private static final Logger LOG = Logger.getLogger(AbstractJSONDAO.class.getName());

    private final String HEADER_JSON;
    private final String FOOTER_JSON = "]}";

    public AbstractJSONDAO(DataProvider fileDataProvider, String fileName, String header) {
        super(fileDataProvider, fileName);
        HEADER_JSON = header;
    }

    protected abstract T parseEntity(final String str);

    public abstract String viewEntity(T entity);

    @Override
    public void create(final T entity) {
        ArrayList<T> list = read();

        try {
            RandomAccessFile file = getDataFile();
            if ((entity.getId() == null) || (entity.getId() == 0L)) {
                entity.setId(getMaxId(list));
            }
            if (file.length() == 0) {
                file.write((HEADER_JSON + "\r\n").getBytes());
                file.write((viewEntity(entity) + "\r\n").getBytes());
                file.write((FOOTER_JSON).getBytes());
            } else {
                file.setLength(file.length() - (("\r\n"+FOOTER_JSON).length()));
                file.write((",\r\n").getBytes());
                file.write((viewEntity(entity) + "\r\n" + FOOTER_JSON).getBytes());
            }
            file.seek(file.length());
        } catch (IOException ex) {
            LOG.log(Level.INFO, "create entity error", ex);
        }
    }

    @Override
    public ArrayList<T> read() {
        ArrayList<T> result = new ArrayList();
        try {
            RandomAccessFile file = getDataFile();
            file.seek(0);
            String str;

            int position = HEADER_JSON.length() + 2;
            file.seek(position);
            // read lines till the end of the stream
            while ((str = file.readLine()) != null && !str.equals("]}")) {
                result.add(parseEntity(str.trim().replaceAll("[\",\\s{}]|id|firstName|lastName|age|streetId", ""))); // оставляем только :
            }
        } catch (IOException e) {
            System.out.println("Error get info from file JSON (Street)");
        }
        return result;
    }

    @Override
    public void update(final T entity) {
        try {
            RandomAccessFile file = getDataFile();
            String buffer = "";
            file.seek(0);
            String str;
            int[] startAndEndOfStr = getStartAndEndOfStr(file, entity);
            long start = startAndEndOfStr[0]; ///jgjgjhgjhghjgjggjgjgjhjgjnewbewnew
            long end = startAndEndOfStr[1];
            file.seek(end - "\t".length());
            while ((str = file.readLine()) != null) {
                buffer += str + "\r\n";
            }
            long lengthBuffer = (file.length() - (FOOTER_JSON).length());
            if (lengthBuffer == (end - ",".length())){
                file.setLength(start);
                file.write((viewEntity(entity) + "\r\n").getBytes());
                file.write(buffer.getBytes());
                file.setLength(start + viewEntity(entity).length() +  buffer.length());
            }
            else {
                file.setLength(start);
                file.write((viewEntity(entity) + ",\r\n").getBytes());
                file.write(buffer.getBytes());
                file.setLength(start + (viewEntity(entity) + ",").length() +  buffer.length());
            }
        file.seek(file.length());
        } catch (IOException e) {
            System.out.println("Error get info from file JSON (Street)");
        }
    }

    @Override
    public void delete(final T entity) {
        try {
            RandomAccessFile file = getDataFile();
            String buffer = "";
            String str;
            file.seek(0);
            int startAndEndOfStr[] = getStartAndEndOfStr(file, entity);
            int start = startAndEndOfStr[0];
            int end = startAndEndOfStr[1];
            file.seek(end - "\t".length());
            while ((str = file.readLine()) != null) {
                buffer += str + "\r\n";
            }
            file.seek(start);
            if (start == end){}
            else {
                long lengthBuffer = (file.length() - (FOOTER_JSON).length());
                if (lengthBuffer == (end - "\t".length())){
                    file.seek(start - ",\r\n".length());
                    file.write(("\r\n" + buffer).getBytes());
                    file.setLength(start + buffer.length() - ",\r\n".length());
                }
                else {
                    file.write((buffer).getBytes());
                    file.setLength(start + buffer.length() - "\r\n".length());
                }
            }
        } catch (IOException e) {
            System.out.println("Error get info from file JSON (Street)");
        }
    }

    /*@Override
    public T getOneById(final long id) {
        T t = null;
        String str;
        try {
            RandomAccessFile file = getDataFile();
            while ((str = file.readLine()) != null) {
                if (str.contains("" + id)) {
                    t = parseEntity(str);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return t;
    }*/

    @Override
    public Long getMaxId(ArrayList<T> list){
        Long maxId = 0L;
        for (int i = 0; !list.isEmpty() && i < list.size(); i++) {
            if(list.get(i).getId() > maxId) maxId = list.get(i).getId();
        }
        return maxId + 1L;
    }

    public int[] getStartAndEndOfStr(RandomAccessFile file, T entity) throws IOException {
        int[] arr = new int[2];
        int start = 0;
        String str = "";
        while ((str = file.readLine()) != null && !(str.startsWith("\t{\"id\":" + entity.getId() + ","))) {
            arr[0] = arr[0] + str.length() + "\t\n".length();
        }
        if(str == null){
            arr[0] = 0;
            arr[1] = arr[0];
        }
        else {
            arr[1] = arr[0] + str.length() + ",\r\n".length();
        }
        return arr;
    }
}