import spock.lang.Shared
import spock.lang.Specification

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class CitizenDAOImplTest extends Specification {

    def @Shared CitizenDAOImpl citizenDAO
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
    def cleanupSpec() {
        citizenDAO.getConnection().close();
    }

    def "isAddedNewCitizen"() {

        expect:
        Citizen citizen = citizenDAO.create(actualFirstName, actualLastName, actualEmail, actualAge, actualStreetId);

        Citizen citizenFromDB = citizenDAO.readOneById(citizen.getId());
        expectedFirstName == citizenFromDB.first_name;
        expectedLastName == citizenFromDB.last_name;
        expectedAge == citizenFromDB.age;
        expectedEmail == citizenFromDB.email;
        expectedStreetId == citizenFromDB.street_id;

        where:
        actualFirstName | actualLastName | actualEmail      | actualAge | actualStreetId | expectedFirstName | expectedLastName | expectedEmail   | expectedAge | expectedStreetId
        "Mark"          | "Walberg"      | "mark@yahoo.com" | 59        | 1L             | "Mark"            | "Walberg"        | "mark@yahoo.com"| 59           | 1L
        "John"          | "Travolta"     | "trav@gmail.com" | 47        | 3L             | "John"            | "Travolta"       | "trav@gmail.com"| 47           | 3L
    }

    def "isReadOneCitizenByID"() {

        expect:

        Citizen citizenFromDB = citizenDAO.readOneById(actualID);
        expectedFirstName == citizenFromDB.first_name;
        expectedLastName == citizenFromDB.last_name;
        expectedAge == citizenFromDB.age;
        expectedEmail == citizenFromDB.email;
        expectedStreetId == citizenFromDB.street_id;

        where:
        actualID | expectedFirstName | expectedLastName | expectedEmail   | expectedAge | expectedStreetId
        19L      | "Mark"            | "Walberg"        | "mark@yahoo.com"| 59          | 1L
        4L       | "Анна"            | "Золотарева"     | ""              | 15          | 0
        11L      | "Тимофей"         | "Ткаченко"       | ""              | 47          | 3L
    }
    def "isReadOneCitizenByEmail"() {

        expect:

        Citizen citizenFromDB = citizenDAO.readOneByEmail(actualEmail);
        expectedFirstName == citizenFromDB.first_name;
        expectedLastName == citizenFromDB.last_name;
        expectedAge == citizenFromDB.age;
        expectedEmail == citizenFromDB.email;
        expectedStreetId == citizenFromDB.street_id;

        where:
        actualEmail      | expectedFirstName | expectedLastName | expectedEmail   | expectedAge | expectedStreetId
        "mark@yahoo.com" | "Mark"            | "Walberg"        | "mark@yahoo.com"| 59          | 1L
        "trav@gmail.com" | "John"            | "Travolta"       | "trav@gmail.com"| 47          | 3L
        "john@yahoo.com" | "John"            | "Doe"            | "john@yahoo.com"| 44          | 5
    }


}
