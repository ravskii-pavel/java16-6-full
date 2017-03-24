import java.sql.*;

public class CitizenDAOImpl implements DAO {
    Connection connection;

    public CitizenDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void create(String first_name, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO citizen (first_name, last_name, age, street_id) VALUES (?, ?, ?, ?)");
        Citizen citizen = new Citizen(user_name, email, password);

        preparedStatement.setString(1, citizen.getFirst_name());
        preparedStatement.setString(2, citizen.getLast_name());
        preparedStatement.setLong(3, citizen.getAge());
        preparedStatement.setLong(4, citizen.getStreet_id());

        preparedStatement.execute();
    }

    public void update(int id, String s1) {

    }

    public void update(int id, String s1, String s2) {

    }

    public void update(int id_new, String user_name, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE citizen SET (first_name = ?, last_name = ?, age = ?, street_id = ?) WHERE id = ?");
        Citizen citizen = new Citizen(user_name, email, password);

        preparedStatement.setString(1, citizen.getUser_name());
        preparedStatement.setString(2, citizen.getEmail());
        preparedStatement.setString(3, citizen.getPassword());
        preparedStatement.setInt(4, id_new);
        preparedStatement.executeUpdate();
    }

    public void delete() {

    }

    public void read() {

    }

    public void readOneById() {

    }

    public void readOneByEmail() {

    }
}
