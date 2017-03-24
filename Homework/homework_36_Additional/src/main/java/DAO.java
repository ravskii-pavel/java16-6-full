import java.sql.SQLException;

public interface DAO {

    void create (String s1, String s2, String s3) throws SQLException;
    void update (int id, String s1);
    void update (int id, String s1, String s2);
    void update (int id, String s1, String s2, String s3) throws SQLException;
    void delete ();
    void read ();
    void readOneById ();
    void readOneByEmail  ();

}
