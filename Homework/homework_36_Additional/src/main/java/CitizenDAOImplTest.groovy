import spock.lang.Shared
import spock.lang.Specification

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException
import java.sql.Statement

class CitizenDAOImplTest extends Specification {

    def @Shared DAO citizenDAO
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
    def @Shared connectionMySQL
    def cleanupSpec() {
        connectionMySQL.close();
    }

    def "ifAddedNewCitizen"() {

        expect:
        Citizen citizen = (Citizen)(citizenDAO.create(actualFirstName, actualLastName, actualEmail, actualAge, actualStreetId));

        expectedFirstName == ((Citizen)citizenDAO.readOneById(citizen.getId())).first_name;
        expectedLastName == ((Citizen)citizenDAO.readOneById(citizen.getId())).last_name;
        expectedAge == ((Citizen)citizenDAO.readOneById(citizen.getId())).age;
        expectedEmail == ((Citizen)citizenDAO.readOneById(citizen.getId())).email;
        expectedStreetId == ((Citizen)citizenDAO.readOneById(citizen.getId())).street_id;


        expectedLastName == ((Citizen)citizenDAO.readOneById(citizen.getId())).last_name;

        where:
        actualFirstName | actualLastName | actualEmail      | actualAge | actualStreetId | expectedFirstName | expectedLastName | expectedEmail   | expectedAge | expectedStreetId
        "Mark"          | "Walberg"      | "mark@yahoo.com" | 59        | 1              | "Mark"            | "Walberg"        | "mark@yahoo.com"| 59L         | 1L

    }

}
