import hiber.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by java on 17.03.2017.
 */

public class Main {

  public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException {

    try {
      Class.forName("com.mysql.jdbc.Driver");
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/forum", "root", "Canada020888");
      Statement statement = connection.createStatement();
      ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");

      ArrayList<User> users = new ArrayList();
      long id;
      String user_name, email;

      while (resultSet.next()) {
        id = resultSet.getLong("id");
        user_name = resultSet.getString("user_name");
        email = resultSet.getString("email");
        //users.add(new hiber.User(user_name, email));
        System.out.println(resultSet.getLong("id")
                + " " + resultSet.getString("user_name")
                + " " + resultSet.getString("email"));
      }

      /*PreparedStatement preparedStatement = connection.prepareStatement
              ("INSERT INTO users (user_name, email) VALUES (?, ?, ?)");

      hiber.User user = new hiber.User("John_Doe", "john@yahoo.com");

      preparedStatement.setString(1, user.getUser_name());
      preparedStatement.setString(2, user.getUser_name());
      preparedStatement.setString(3, user.getUser_name());

      preparedStatement.execute();*/




      connection.close();
    } catch (SQLException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
