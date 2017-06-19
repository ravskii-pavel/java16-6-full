package web.dao;

/**
 * Created by Ravskiy Pavel on 21.05.2017.
 */
public interface DataProvider {

    enum ConnectionType {
        MYSQL, JSON
    }
    void openConnection();
    void closeConnection();
}