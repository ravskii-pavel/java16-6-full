import java.sql.SQLException;
import java.util.ArrayList;

public interface DAO {

    void create (String first_name, String last_name, int age, long street_id) throws SQLException;
    void update (long id, long street_id) throws SQLException;
    void delete ();
    ArrayList read () throws SQLException;
    void readOneById () throws SQLException;
    void readOneByEmail  ();

}
