import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAOImpl implements DAO {
    Connection connection;
    long id;
    String firstName;
    String lastName;
    int age;
    long streetId;

    public CitizenDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void create (String first_name, String last_name, String email, int age, long street_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO citizen (first_name, last_name, age, street_id) " +
                        "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        Citizen citizen = new Citizen(first_name, last_name, email, age, street_id);

        preparedStatement.setString(1, citizen.getFirst_name());
        preparedStatement.setString(2, citizen.getLast_name());
        preparedStatement.setLong(3, citizen.getAge());
        preparedStatement.setLong(4, citizen.getStreet_id());
        preparedStatement.execute();
    }


    public void update(long id, long street_id) throws SQLException  {
        PreparedStatement update = connection.prepareStatement("UPDATE citizen SET street_id = ? WHERE id = ?");
        update.setLong(1, street_id);
        update.setLong(2, id);
        update.executeUpdate();
    }

    public void update(long id, String email) throws SQLException {
        PreparedStatement update = connection.prepareStatement("UPDATE citizen SET email = ? WHERE id = ?");
        update.setString(1, email);
        update.setLong(2, id);
        update.executeUpdate();
    }

    public void update(long id, String last_name, long street_id) throws SQLException {
        PreparedStatement update = connection.prepareStatement("UPDATE citizen SET last_name = ?, street_id = ? WHERE id = ?");
        update.setString(1, last_name);
        update.setLong(2, street_id);
        update.setLong(3, id);
        update.executeUpdate();
    }

    public void delete(long id) throws SQLException {
        PreparedStatement update = connection.prepareStatement("DELETE citizen WHERE id = ?");
        update.setLong(1, id);
        update.executeUpdate();
    }

    public ArrayList<Citizen> read() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CITIZEN");

        ArrayList<Citizen> citizenList = new ArrayList();
        while (resultSet.next()) {
            long id = resultSet.getLong("ID");
            String firstName = resultSet.getString("FIRST_NAME");
            String lastName = resultSet.getString("LAST_NAME");
            String email = resultSet.getString("EMAIL");
            int age = resultSet.getInt("AGE");
            long streetId = resultSet.getLong("STREET_ID");

            citizenList.add(new Citizen(id, firstName, lastName, email, age, streetId));

        }
        return citizenList;
    }

    public void readOneById(long id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CITIZEN WHERE id = ?");

        while (resultSet.next()) {
            id = resultSet.getLong("ID");
            String firstName = resultSet.getString("FIRST_NAME");
            String lastName = resultSet.getString("LAST_NAME");
            String email = resultSet.getString("EMAIL");
            int age = resultSet.getInt("AGE");
            long streetId = resultSet.getLong("STREET_ID");

            new Citizen(id, firstName, lastName, email, age, streetId);
        }
    }

    public Citizen readOneByEmail(String email) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CITIZEN WHERE email = ?");

        while (resultSet.next()) {
            long id = resultSet.getLong("ID");
            firstName = resultSet.getString("FIRST_NAME");
            lastName = resultSet.getString("LAST_NAME");
            email = resultSet.getString("EMAIL");
            age = resultSet.getInt("AGE");
            streetId = resultSet.getLong("STREET_ID");
        }
        return new Citizen(id, firstName, lastName, email, age, streetId);
    }
}
