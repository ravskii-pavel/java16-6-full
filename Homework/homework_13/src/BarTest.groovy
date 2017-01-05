
import spock.lang.Specification;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
/**
 * Created by Pavel on 20.12.2016.
 */

class BarTest extends Specification {

    def "add employeeTest"(){
       Bar bar = new Bar();

       int age = 22;
       String name = "Max";
       String position = "manager";
       String actualPositions;
       String expectedPositions = "Нет такой должности - " + position;

        when:
        actualPositions = bar.addEmployee(name, age, position, bar);

        then:
        assertEquals(expectedPositions, actualPositions);
    }

}

