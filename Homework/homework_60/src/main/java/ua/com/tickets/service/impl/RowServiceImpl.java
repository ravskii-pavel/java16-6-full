package ua.com.tickets.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.tickets.core.model.Hall;
import ua.com.tickets.core.model.Row;
import ua.com.tickets.core.model.TypeRow;
import ua.com.tickets.dao.RowDao;
import ua.com.tickets.service.RowService;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Service
public class RowServiceImpl implements RowService {

    private RowDao rowDao;

    @Autowired
    public void setRowDao(RowDao rowDao) {
        this.rowDao = rowDao;
    }

    @Override
    public void createRow(Row row) {
        rowDao.createRow(row);
    }

    @Override
    public void createListRows(int quantityRowsInHall, Hall hall) {
        Row row;
        List<Row> rowList = new ArrayList<>();
        for (int num=1; num<=quantityRowsInHall; num++) {
            if(num != quantityRowsInHall) row = new Row(num, hall);
            else row = new Row(num, TypeRow.LUX, hall);
            this.createRow(row);
            rowList.add(row);
        }
        hall.setRowList(rowList);
    }

    @Override
    public List<Row> getAllRows() {
        return rowDao.getAllRows();
    }

    @Override
    public Row getRowById(Long id) {
        return rowDao.getRowById(id);
    }

    @Override
    public void updateRow(Row row) {
        rowDao.updateRow(row);
    }

    @Override
    public void deleteRow(Row row) {
        rowDao.deleteRow(row);
    }
}
