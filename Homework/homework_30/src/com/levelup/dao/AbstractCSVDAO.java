package com.levelup.dao;

import com.levelup.dao.impl.FileDataProviderImpl;
import com.levelup.entity.Citizen;
import com.levelup.entity.Entity;
import com.levelup.entity.Street;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;

/**
 * Created by java on 28.02.2017.
 */
public abstract class AbstractCSVDAO<T extends Street> extends AbstractFileDAO<T> {

    private final String HEADER_CSV;

    public AbstractCSVDAO(FileDataProviderImpl fileDataProvider, String fileName, String header_csv) {
        super(fileDataProvider, fileName);
        HEADER_CSV = header_csv;
    }

    protected abstract T parseEntity(final String str);

    public abstract String viewEntity(T entity);

    public long[] getStartAndEndOfStr(RandomAccessFile file, T entity) {
        long[] arr = new long[2];

        String line;
        try {
            file.seek((HEADER_CSV + "\r\n").length());

            while ((line = file.readLine()) != null) {
                if (line.startsWith(entity.getId() + ";")) {
                    arr[1] = file.getFilePointer();
                    arr[0] = file.getFilePointer() - line.length();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arr;
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
    public void create(T entity) {
        ArrayList<T> list = read();
        entity.setId(getMaxId(list));

        try {
            RandomAccessFile file = getDataFile();
            file.seek(file.length());

            file.write(viewEntity(entity).getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(T entity) {
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
    public void update(T entity) {
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

    public Long getMaxId(ArrayList<T> list){
        Long maxId = 0L;
        for (int i = 0; !list.isEmpty() && i < list.size(); i++) {
            if(list.get(i).getId() > maxId) maxId = list.get(i).getId();
        }
       return maxId + 1L;
    }
}
