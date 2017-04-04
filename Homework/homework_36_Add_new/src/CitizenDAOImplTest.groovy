import spock.lang.Shared
import spock.lang.Specification

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class CitizenDAOImplTest extends Specification {

    def @Shared DAO citizenDAO
    def @Shared connectionMySQL
    def setupSpec() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connectionMySQL = DriverManager.getConnection("jdbc:mysql://localhost:3306/address_book", "root", "Canada020888");
            citizenDAO = new CitizenDAOImpl(connectionMySQL);
            Statement statement = connectionMySQL.createStatement();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
//       def cleanupSpec() {
//             connectionMySQL.close();
//       }

    def "ifAddedNewCitizen"() {

        expect:
        Citizen citizen = (Citizen)(citizenDAO.create(actualFirstName, actualLastName, actualEmail, actualAge, actualStreetId));
        Citizen getCitizen = (Citizen)(citizenDAO.readOneById(citizen.getId()));

        expectedFirstName == getCitizen.first_name;
        expectedLastName == getCitizen.last_name;
        expectedAge == getCitizen.age;
        expectedEmail == getCitizen.email;
        expectedStreetId == getCitizen.street_id;


        expectedLastName == ((Citizen)citizenDAO.readOneById(citizen.getId())).last_name;

        where:
        actualFirstName | actualLastName | actualEmail      | actualAge | actualStreetId | expectedFirstName | expectedLastName | expectedEmail   | expectedAge | expectedStreetId
        "Mark"          | "Walberg"      | "mark@yahoo.com" | 59        | 1L            | "Mark"            | "Walberg"        | "mark@yahoo.com"| 59           | 1L

    }


}
