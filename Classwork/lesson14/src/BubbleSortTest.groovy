import spock.lang.Specification

import static org.junit.Assert.assertArrayEquals

/**
 * Created by java on 20.12.2016.
 */
class BubbleSortTest extends Specification {
    def "BubbleSort test1"() {
        int[] actual = [4,0,-2];
        int[] expected = [-2,0,4];
        when:
        BubbleSort.bubbleSort(actual);

        then:
        assertArrayEquals(expected, actual);

    }
    def "BubbleSort test2"() {

        int[] actual = [0, 1, 3, 5, 6, 8];
        int[] expected = [0, 1, 3, 5, 6, 8];

        when:
        BubbleSort.bubbleSort(actual);

        then:
        assertArrayEquals(expected, actual);
    }
    def "BubbleSort test3"() {

        int[] actual = [8, 8, 3, 5, 6, 8];
        int[] expected = [3, 5, 6, 8, 8, 8];

        when:
        BubbleSort.bubbleSort(actual);

        then:
        assertArrayEquals(expected, actual);
    }
    def "BubbleSort test4"() {

        int[] actual = [];
        int[] expected = [];

        when:
        BubbleSort.bubbleSort(actual);

        then:
        assertArrayEquals(expected, actual);
    }
}
