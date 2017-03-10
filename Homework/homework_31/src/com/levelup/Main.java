package com.levelup;

import com.levelup.dao.DAO;
import com.levelup.dao.DataProvider;
import com.levelup.dao.impl.CitizenCSVDAOImpl;
import com.levelup.dao.impl.CitizenJSONDAOImpl;
import com.levelup.dao.impl.FileDataProviderImpl;
import com.levelup.dao.impl.StreetCSVDAOImpl;
import com.levelup.entity.Citizen;
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
       // new MyDataTableFrame();

//~~~~~~~~~~~~~~~~~~~~~~~ CSV ~~~~~~~~~~~~~~~~~~~~~~~~~~~~
        //FileDataProviderImpl provider = new FileDataProviderImpl("");
        //DAO<Street> streetDAO = new StreetCSVDAOImpl(provider, "street.csv");
        //DAO<Citizen> streetDAO = new CitizenCSVDAOImpl(provider, "citizen.csv");
        //provider.openConnection();
        //streetDAO.create(new Citizen("John", "Doe", 38, 3L));

//~~~~~~~~~~~~~~~~~~~~~~~ JSON ~~~~~~~~~~~~~~~~~~~~~~~~~~~~

        //String citizen = "\t{\"id\": 1, \"firstName\": \"John\", \"lastName\": \"Doe\", \"age\": 46, \"streetId\": 21},";

        //System.out.println(citizen.trim().replaceAll("[\",\\s{}]|id|firstName|lastName|age|streetId", ""));

        FileDataProviderImpl provider = new FileDataProviderImpl("");
        DAO<Citizen> citizenDAO = new CitizenJSONDAOImpl(provider, "citizen.json");
        provider.openConnection();
        citizenDAO.create(new Citizen("John", "Doe", 11, 81L));
        //citizenDAO.delete(new Citizen(44L, "1", "2", 901111, 5555L));
        //citizenDAO.update(new Citizen(46L, "------", "+++++++", 377, 90L));
        //citizenDAO.update(new Citizen(44L, "Silvester", "Stalone", 377, 90L));

        //streetDAO.create(new Street("Kirova"));id":5, "firstName": "John", "lastName": "Doe", "age":38, "streetId":3
    }

}
