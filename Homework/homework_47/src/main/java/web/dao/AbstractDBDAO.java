package web.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import web.dao.impl.DBDataProviderImpl;
import web.entity.User;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ravskiy Pavel on 24.05.2017.
 */
public abstract class AbstractDBDAO<T> implements DAO<T> {

    protected final DBDataProviderImpl dbDataProvider;

    public AbstractDBDAO(){
        dbDataProvider = new DBDataProviderImpl();
    }

    public AbstractDBDAO(DataProvider dataProvider) {
        this.dbDataProvider = (DBDataProviderImpl) dataProvider;
    }

/*    @Override
    public void create(T t) {
        Transaction transaction = dbDataProvider.getSession().getTransaction();
        transaction.begin();
        dbDataProvider.getSession().save(t);*//*session.update(user); чтобы работало нужно true, если false тогда нужно через insert--> *//*
        transaction.commit();
    }*/
}