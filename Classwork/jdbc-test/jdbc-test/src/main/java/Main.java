
import hiber.User;

import java.sql.*;
import java.util.Arrays;
import java.util.List;

/**
 * Created by java on 17.03.2017.
 */

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException, IllegalAccessException, InstantiationException {
        Class.forName("com.mysql.jdbc.Driver");

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/forum",
                "root", "qwerty");

        PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO USERS (USERNAME, EMAIL, PASSWORD) VALUES(?,?,?)",
                        Statement.RETURN_GENERATED_KEYS);
//
        User user = new User("Albus Dumbldor", "dumbldor@yopmail.com", "1234");
        User user1 = new User("Gordon Friman", "friman@yopmail.com", "1234");
        User user2 = new User("Lara Croft", "croft@yopmail.com", "1234");
        User user3 = new User("John Cena", "cena@yopmail.com", "1234");

        List<User> list = Arrays.asList(user, user1, user2, user3);

        for (User u : list) {
            preparedStatement.setString(1, u.getName());
            preparedStatement.setString(2, u.getEmail());
            preparedStatement.setString(3, u.getPassword());

            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();

        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        for (int i = 0; generatedKeys.next(); i++) {
            User u = list.get(i);

            long id = generatedKeys.getLong("GENERATED_KEY");
            u.setId(id);
        }

        PreparedStatement update =
                connection.prepareStatement("UPDATE USERS SET USERNAME = ?, EMAIL = ? WHERE ID = ?");

        User max = new User("Max Payne1", "max42@yopmail.com", "1235");
        max.setId(2);

        update.setString(1, max.getName());
        update.setString(2, max.getEmail());
        update.setLong(3, max.getId());

        update.execute();


//
//
//        Statement statement = connection.createStatement();
//
//        ResultSet resultSet = statement.executeQuery("SELECT * FROM USERS");
//
//        List<hiber.User> userList = new ArrayList<hiber.User>();
//        while (resultSet.next()) {
//            long id = resultSet.getLong("ID");
//            String username = resultSet.getString("USERNAME");
//            String email = resultSet.getString("EMAIL");
//            String pass = resultSet.getString("PASSWORD");
//
//            userList.add(new hiber.User(id, username, email, pass));
//
//            System.out.println(resultSet.getLong("ID")
//                    + " " + resultSet.getString("USERNAME")
//                    + " " + resultSet.getString("EMAIL"));
//        }
//
//
//        System.out.println(userList);
//
        connection.close();

//        List<Integer> list = Arrays.asList(1,1 ,2,2 , 3,3 , 4,4 , 7, 9,9 , 8,8);
//
//        Collections.shuffle(list);
//
//        int res = 0;
//        for (Integer i : list) {
//            res = res ^ i;
//        }
//
//        System.out.println(res);
    }
}
