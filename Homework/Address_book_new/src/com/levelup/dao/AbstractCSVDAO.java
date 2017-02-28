package com.levelup.dao;

import com.levelup.dao.impl.FileDataProviderImpl;
import com.levelup.entity.Citizen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by ravskiy on 28.02.2017.
 */
public abstract class AbstractCSVDAO<T> extends AbstractFileDAO<T>{

    private String HEADER_CSV = "D:\\";

    protected AbstractCSVDAO(final FileDataProviderImpl fileDataProvider, String fileName, final String HEADER_CSV) {
        super(fileDataProvider, fileName); this.HEADER_CSV = HEADER_CSV;
    }

    public void create(){

    }
    public List<Citizen> read(String fileName){
        List<Citizen> list = new ArrayList<>();

        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));) {
            String line;

            while ((line = reader.readLine()) != null) {
                if (line.startsWith("id"))continue;
                Scanner scanner = new Scanner(line);
                scanner.useDelimiter(";");

                long id = scanner.nextLong();
                String fName = scanner.next();
                String lName = scanner.next();
                int age = scanner.nextInt();
                long streetId = scanner.nextLong();

                list.add(new Citizen(id, fName, lName, age, streetId));
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

        public void update(final T t) {}
        public void delete(final T t) {}
        //public T getOneById(final long id) {}

        public abstract String viewEntity(T t);
        protected abstract T parseEntity(final String str);
        //public int[] getStartAndEndOfStr(RandomAccessFile file, T t) {}
}
