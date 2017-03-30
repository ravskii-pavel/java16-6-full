import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO<T> {

    void create (String first_name, String last_name, String email, int age, long street_id) throws SQLException;
    void update (long id, String email) throws SQLException;
    void delete (long id) throws SQLException;
    ArrayList read () throws SQLException;
    void readOneById (long id) throws SQLException;
    T readOneByEmail (String email) throws SQLException;

}
