package com.levelup;

import com.levelup.dao.DAO;
import com.levelup.dao.DataProvider;
import com.levelup.dao.impl.FileDataProviderImpl;
import com.levelup.dao.impl.StreetCSVDAOImpl;
import com.levelup.entity.Street;
import com.levelup.view.MyDataTableFrame;
import com.levelup.view.impl.CitizenTablePanel;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by java on 10.01.2017.
 */
public class Main {

    public static void main(String[] args) {
//        new MyDataTableFrame();

        FileDataProviderImpl provider = new FileDataProviderImpl("");

        DAO<Street> streetDAO = new StreetCSVDAOImpl(provider, "street.csv");
        //StreetCSVDAOImpl streetDAO = new StreetCSVDAOImpl(provider, "street.csv");
        provider.openConnection();

        //streetDAO.create(new Street(8968L, "Topolia_11"));
        //streetDAO.create(new Street(1L, "Gagarina"));
        //streetDAO.create(new Street(2L, "Lenina"));
        //streetDAO.create(new Street(3L, "Plehanova"));
        //streetDAO.create(new Street(4L, "Artema"));
        streetDAO.create(new Street("Lenina"));
        //streetDAO.create(new Street(77L, "Titova"));
        //Street street = new Street(4L, "Artema");
        //streetDAO.delete(new Street(4L, "Artema"));
        //streetDAO.create(new Street(89L, "Topolia_1"));
        //streetDAO.create(new Street(99L, "Topolia_2"));
        /*streetDAO.update(new Street(4L, "NewNewNew"));
        streetDAO.update(new Street(2L, "---------------------"));
        streetDAO.delete(new Street(2L, ""));*/
        //streetDAO.
        //streetDAO.
//        ArrayList<Street> streets = streetDAO.read();

  //      System.out.println(streets);
    }

}
