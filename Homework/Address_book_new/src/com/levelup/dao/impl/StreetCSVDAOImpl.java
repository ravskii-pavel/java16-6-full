package com.levelup.dao.impl;

import com.levelup.dao.AbstractCSVDAO;

import java.util.ArrayList;

/**
 * Created by ravskiy on 28.02.2017.
 */
public class StreetCSVDAOImpl extends AbstractCSVDAO {
    public StreetCSVDAOImpl(final FileDataProviderImpl fileDataProvider) {
        super(fileDataProvider, "street.csv", "id;streetName");
    }
    @Override
    public String viewEntity(final Street street) {
        return String.format("%d;%s", street.getId(), street.getStreetName());
    }

    @Override
    public String viewEntity(Object o) {
        return null;
    }

    @Override
    protected Street parseEntity(final String str) {
        String[] arr = str.split(";");
        return new Street(Long.parseLong(arr[0]), arr[1]);
    }

    @Override
    public void create(Object o) {

    }

    @Override
    public ArrayList read() {
        return null;
    }
}
