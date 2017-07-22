package ua.com.tickets.dao;

import ua.com.tickets.core.model.Hall;
import ua.com.tickets.core.model.Row;

import java.util.List;

public interface RowDao {
    void createRow(Row row);
    List<Row> getAllRows();
    Row getRowById(Long id);
    void updateRow(Row row);
    void deleteRow(Row row);
}
