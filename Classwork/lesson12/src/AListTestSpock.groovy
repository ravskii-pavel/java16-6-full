/**
 * Created by java on 16.12.2016.
 */
import org.junit.Before;
import org.junit.Test;
import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;

import static org.junit.Assert.*;
import spock.lang.Specification

class AListTestSpock extends Specification {

    def 'check is add element correct' (){

        given: 'initialize Alist'
        AList list = new AList();
        int exp = 1;

        when: 'Try to add one element'
        list.add(5)

        int act = list.size()

        then: 'Check list size'
        assertEquals(exp, act)

        /*list.size() == 0*/
/*        where:
        num << [0, 5, 7, 256, 99]*/
    }
}
