package com.levelup.dao;

import com.levelup.dao.impl.FileDataProviderImpl;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * Created by ravskiy on 28.02.2017.
 */
public abstract class AbstractFileDAO<T> implements DAO<T>{
    private Long id;
    protected FileDataProviderImpl fileDataProvider;
    private String fileName;

    public AbstractFileDAO(FileDataProviderImpl fileDataProvider, String fileName) {
        this.fileDataProvider = fileDataProvider;
        this.fileName = fileName;
        fileDataProvider.appendFile(fileName);
    }
    public RandomAccessFile getDataFile() throws FileNotFoundException {
        return fileDataProvider.getDataFile(fileName);
    }
}
