package com.levelup.dao.impl;

import com.levelup.dao.DataProvider;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by java on 24.02.2017.
 */
public class FileDataProviderImpl implements DataProvider {

    private static final String READ_WRITE_ACCESS = "rw";
    private Map<String, RandomAccessFile> dataMap= new HashMap<>();
    private StringBuilder files = new StringBuilder();
    private final String packagePath;

    public FileDataProviderImpl(final String packagePath) {
        this.packagePath = packagePath;
    }

    public RandomAccessFile getDataFile (String fileName) throws FileNotFoundException {
        if(dataMap.containsKey(fileName)){
            return dataMap.get(fileName);
        }
        File file = new File(packagePath + File.pathSeparator + fileName);

        RandomAccessFile randomAccessFile = new RandomAccessFile(file, READ_WRITE_ACCESS);
        dataMap.put(fileName, randomAccessFile);
        return randomAccessFile;
    }

    @Override
    public void openConnection() {

    }

    @Override
    public void closeConnection() {

    }

    public void appendFile(final String fileName){
        files.append(fileName + ";");
    }
}
