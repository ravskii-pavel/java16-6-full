import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CitizenDAOImpl implements DAO {
    Connection connection;

    public CitizenDAOImpl(Connection connection) {
        this.connection = connection;
    }

    public void create (String first_name, String last_name, int age, long street_id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO citizen (first_name, last_name, age, street_id) " +
                        "VALUES (?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);

        Citizen citizen = new Citizen(first_name, last_name, age, street_id);

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

    public void update(long id, String last_name) throws SQLException {
        PreparedStatement update = connection.prepareStatement("UPDATE citizen SET last_name = ? WHERE id = ?");
        update.setString(1, last_name);
        update.setLong(2, id);
        update.executeUpdate();
    }

    public void update(long id, String last_name, long street_id) throws SQLException {
        PreparedStatement update = connection.prepareStatement("UPDATE citizen SET last_name = ?, street_id = ? WHERE id = ?");
        update.setString(1, last_name);
        update.setLong(2, street_id);
        update.setLong(3, id);
    }

    /*public void update(int id_new, String user_name, String email, String password) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("UPDATE citizen " +
                "SET (first_name = ?, last_name = ?, age = ?, street_id = ?) WHERE id = ?");
        Citizen citizen = new Citizen(user_name, email, password);

        preparedStatement.setString(1, citizen.getUser_name());
        preparedStatement.setString(2, citizen.getEmail());
        preparedStatement.setString(3, citizen.getPassword());
        preparedStatement.setInt(4, id_new);
        preparedStatement.executeUpdate();
    }*/

    public void delete(long id) throws SQLException {
        PreparedStatement update = connection.prepareStatement("DELETE citizen WHERE id = ?");
        update.setLong(1, id);
    }

    public ArrayList<Citizen> read() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CITIZEN");

        ArrayList<Citizen> citizenList = new ArrayList();
        while (resultSet.next()) {
            long id = resultSet.getLong("ID");
            String firstName = resultSet.getString("FIRST_NAME");
            String lastName = resultSet.getString("LAST_NAME");
            int age = resultSet.getInt("AGE");
            long streetId = resultSet.getLong("STREET_ID");

            citizenList.add(new Citizen(id, firstName, lastName, age, streetId));

        }
        return citizenList;
    }

    public void readOneById(long id) throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM CITIZEN");

        ArrayList<Citizen> citizenList = new ArrayList();
        while (resultSet.next()) {
            long id = resultSet.getLong("ID");
            String firstName = resultSet.getString("FIRST_NAME");
            String lastName = resultSet.getString("LAST_NAME");
            int age = resultSet.getInt("AGE");
            long streetId = resultSet.getLong("STREET_ID");

            citizenList.add(new Citizen(id, firstName, lastName, age, streetId));

        }
        return citizenList;
    }

    public void readOneByEmail() {

    }
}
