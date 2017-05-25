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
    protected final Session session;

    public AbstractDBDAO(DataProvider dataProvider) {
        this.dbDataProvider = (DBDataProviderImpl) dataProvider;
        this.session = dbDataProvider.getSession();
    }

    public DBDataProviderImpl getDbDataProvider() { return dbDataProvider; }

    public Session getSession() { return session; }
    /*    public AbstractDBDAO() {}*/

    @Override
    public void create(T t) {
        Transaction transaction = session.getTransaction();
        transaction.begin();
        session.save(t);/*session.update(user);*/
        transaction.commit();
    }
}