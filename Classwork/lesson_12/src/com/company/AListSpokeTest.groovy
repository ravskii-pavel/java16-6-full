package com.company

import spock.lang.Specification

/**
 * Created by java on 16.12.2016.
 */
class AListSpokeTest extends Specification {
    def 'check is add element correct'(){
        given: 'initialize AList'
        AList list = new AList();

        when: 'Try to add one element'
        list.add(num)

        then: 'Check list size'
        list.size() == 0

        where:
        num << [0, 5, 7, 256]
    }
}
