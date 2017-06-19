package com.levelup.dao;

import com.levelup.dao.impl.FileDataProviderImpl;
import com.levelup.entity.Entity;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by java on 28.02.2017.
 */
public abstract class AbstractCSVDAO<T extends Entity> extends AbstractFileDAO<T> {

    private static final Logger LOG = Logger.getLogger(AbstractCSVDAO.class.getName());

    private final String HEADER_CSV;

    public AbstractCSVDAO(DataProvider fileDataProvider, String fileName, String header_csv) {
        super(fileDataProvider, fileName);
        HEADER_CSV = header_csv;
    }

    protected abstract T parseEntity(final String str);

    public abstract String viewEntity(T entity);

    @Override
    public void create(final T entity) {
        ArrayList<T> list = read();
        entity.setId(getMaxId(list));

        try {
            RandomAccessFile file = getDataFile();
            if (file.length() < (HEADER_CSV.length())) {
                file.write((HEADER_CSV + "\r\n").getBytes());
            } else {
                file.seek(file.length());
            }
            file.write(viewEntity(entity).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public ArrayList<T> read() {
        ArrayList<T> list = new ArrayList<>();

        RandomAccessFile file = null;
        try {
            file = getDataFile();
            file.seek(0);
            String line;
            while ((line = file.readLine()) != null) {
                if(line.contains(HEADER_CSV)) continue;
                list.add(parseEntity(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public void update(final T entity) {
        ArrayList<T> list = read();

        try {
            RandomAccessFile file = getDataFile();
            String line;
            file.setLength((HEADER_CSV + "\r\n").length());
            file.seek((HEADER_CSV + "\r\n").length());
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getId() == entity.getId()){
                    list.remove(i);
                    list.add(i, entity);
                }
                file.write(viewEntity(list.get(i)).getBytes());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(final T entity) {
        ArrayList<T> list = read();
        try {
            RandomAccessFile file = getDataFile();
            String line;
            file.setLength((HEADER_CSV + "\r\n").length());
            file.seek((HEADER_CSV + "\r\n").length());
            for (int i = 0; i < list.size(); i++){
                if (list.get(i).getId() != entity.getId()){
                    file.write(viewEntity(list.get(i)).getBytes());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Long getMaxId(ArrayList<T> list){
        Long maxId = 0L;
        for (int i = 0; !list.isEmpty() && i < list.size(); i++) {
            if(list.get(i).getId() > maxId) maxId = list.get(i).getId();
        }
        return maxId + 1L;
    }
}
