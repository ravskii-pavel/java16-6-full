package ua.com.tickets.service;

import ua.com.tickets.core.model.Hall;
import ua.com.tickets.core.model.Row;

import java.util.List;

/**
 * Created by ravskiy on 20.07.17.
 */
public interface RowService {
    void createRow(Row row);
    void createListRows(int quantityRowsInHall, Hall hall);
    List<Row> getAllRows();
    Row getRowById(Long id);
    void updateRow(Row row);
    void deleteRow(Row row);
}
