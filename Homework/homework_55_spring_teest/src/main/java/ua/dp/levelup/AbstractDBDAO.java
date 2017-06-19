package ua.dp.levelup;

/**
 * Created by Ravskiy Pavel on 24.05.2017.
 */
public abstract class AbstractDBDAO<T> implements DAO<T> {

    protected final DBDataProvider dbDataProvider;

    public AbstractDBDAO(DBDataProvider dbDataProvider){
        this.dbDataProvider = dbDataProvider;
    }

    public AbstractDBDAO() {
        dbDataProvider = new DBDataProvider();
    }
    /*    @Override
    public void create(T t) {
        Transaction transaction = dbDataProvider.getSession().getTransaction();
        transaction.begin();
        dbDataProvider.getSession().save(t);*//*session.update(user); чтобы работало нужно true, если false тогда нужно через insert--> *//*
        transaction.commit();
    }*/
}