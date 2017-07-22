package ua.com.tickets.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ua.com.tickets.core.model.Hall;
import ua.com.tickets.core.model.Row;
import ua.com.tickets.core.model.Seat;
import ua.com.tickets.core.model.TypeRow;
import ua.com.tickets.dao.RowDao;

import java.util.List;

@Repository
@Transactional
public class RowDaoImpl implements RowDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void createRow(Row row) {
        hibernateTemplate.save(row);
    }

    @Override
    public List<Row> getAllRows() {
        return hibernateTemplate.loadAll(Row.class);
    }

    @Override
    public Row getRowById(Long id) {
        return hibernateTemplate.load(Row.class, id);
    }

    @Override
    public void updateRow(Row row) {
        hibernateTemplate.update(row);
    }

    @Override
    public void deleteRow(Row row) {
        hibernateTemplate.delete(row);
    }
}
