//import org.apache.tools.ant.taskdefs.optional.extension.Specification
import spock.lang.Shared
import spock.lang.Specification;

//import static org.junit.Assert.assertArrayEquals;
//import static org.junit.Assert.assertEquals;
/**
 * Created by Pavel on 20.12.2016.
 */

class BarTest extends Specification {

    // Must be @Shared or static!
    def @Shared Bar uglyCoyote
    def setupSpec(){
        uglyCoyote = new Bar("BarTest");
        uglyCoyote.addEmployee("Tom", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("Tommy", 25, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("John", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("John1", 24, "waiter", uglyCoyote);
        uglyCoyote.addEmployee("Alex", 30, "barman", uglyCoyote);
        uglyCoyote.addEmployee("Michal", 30, "barman", uglyCoyote);

        uglyCoyote.addDrinkInBar("Whiskey", 1250);
        uglyCoyote.addDrinkInBar("Whiskey", 1150);
        uglyCoyote.addDrinkInBar("Rom", 1259);
        uglyCoyote.addDrinkInBar("Tequila", 2000);

        uglyCoyote.waiters[0].takeOrder("Whiskey", 2230);
        uglyCoyote.waiters[0].takeOrder("Whiskey", 100);
        uglyCoyote.waiters[0].takeOrder("Tequila", 1880);
        uglyCoyote.waiters[0].takeOrder("Tequila", 108);
    }

    def "ifAddDrinkInBarExist"() {

        expect:
        uglyCoyote.addDrinkInBar(actualName, actualQuantity);
        expectedName == uglyCoyote.typeDrinks[uglyCoyote.whichDrinkAnalog(actualName)].nameDrink;
        expectedQuntity == uglyCoyote.typeDrinks[uglyCoyote.whichDrinkAnalog(actualName)].quantityMlLitres;

        where:
        actualName | actualQuantity | expectedName | expectedQuntity
        "scotch"   | 110            | "scotch"     | 110
        "scotch"   | 330            | "scotch"     | 440
        "scotch"   | 1360           | "scotch"     | 1800
    }

    def "shareAllTipsTest"() {

        expect:
        uglyCoyote.waiters[0].takeTips(tips);
        uglyCoyote.waiters[1].takeTips(60);
        expectedTipsOnEmployee == uglyCoyote.shareAllTips();

        where:
        tips | expectedTipsOnEmployee
        240  | 50
        300  | 60
        600  | 110
        -600 | 10
        -120 | 10
        0    | 10
    }
    def "ifPositionEmployeeNotExistsTest"() {

        int age = 22;
        String name = "Max";

        expect:
        expectedPositions == uglyCoyote.addEmployee(name, age, actualPositions, uglyCoyote);

        where:
        expectedPositions                | actualPositions
        "waiter"                         | "waiter"
        "barman"                         | "barman"
        "Нет такой должности - manager"  | "manager"
        "Нет такой должности - director" | "director"
        "Нет такой должности - null"     | null
    }
    def "isOrderCompleateTest"() {

        expect:
        expectedResult == uglyCoyote.barmen[0].compleateOrder(numOrder);

        where:
        numOrder | expectedResult
        0        | "Заказ 0 - выполнен"
        1        | "Заказ 1 - выполнен"
        2        | "Заказ 2 - выполнен"
        0        | "Нет заказа с таким №: 0"
        4        | "Нет заказа с таким №: 4"
        0        | "Нет заказа с таким №: 0"
        -7       | "Нет заказа с таким №: -7"
    }

}