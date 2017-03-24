import java.sql.*;
import java.util.ArrayList;

/**
 * Created by java on 17.03.2017.
 */

public class Main {

  public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException {

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book", "root", "Canada020888");
      CitizenDAOImpl citizenDAO = new CitizenDAOImpl(connectionMySQL);
      citizenDAO.create("John Doe", "john@yahoo.com", "doe1234");
      Statement statement = connectionMySQL.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM citizen");

      ArrayList<Citizen> citizens = new ArrayList();
      long id;
      String user_name, email, password;

      while (resultSet.next()) {
        id = resultSet.getLong("id");
        user_name = resultSet.getString("user_name");
        email = resultSet.getString("email");
        password = resultSet.getString("password");
        citizens.add(new Citizen(user_name, email, password));
        System.out.println(resultSet.getLong("id")
                + " " + resultSet.getString("user_name")
                + " " + resultSet.getString("email"));
      }

      /*PreparedStatement preparedStatement = connection.prepareStatement
              ("INSERT INTO citizens (user_name, email) VALUES (?, ?, ?)");

      Citizen user = new Citizen("John_Doe", "john@yahoo.com");

      preparedStatement.setString(1, user.getUser_name());
      preparedStatement.setString(2, user.getUser_name());
      preparedStatement.setString(3, user.getUser_name());

      preparedStatement.execute();
      */




      connectionMySQL.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
