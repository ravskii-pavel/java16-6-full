public class Main {
    import org.junit.Before;
    import org.junit.Test;
    import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;

    import static org.junit.Assert.;

    /*
     * Created by java on 13.12.2016.
     */
    public class AListTest {

        AList list;

        @Before
        public void setUp() {
            list = new AList();
        }

        @Test
        public void shouldCheckThatListisEmpty() throws Exception {
            //given
            int expected = 0;

            //when
            list.add(0);
            int actual = list.size();

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 1", expected, actual);
        }

        @Test
        public void shouldAddElementAndReturnSizeOne() throws Exception {
            //given
            int expected = 1;

            //when
            list.add(5);
            int actual = list.size();

            //then

            assertEquals("ERROR!!! Actual result is wrong ! Expected is 1", expected, actual);
        }

        @Test
        public void shouldAddElementAndReturnSizeTwo() throws Exception {
            //given
            int expected = 2;

            //when
            list.add(5);
            list.add(6);
            int actual = list.size();

            //then

            assertEquals("ERROR!!! Actual result is wrong ! Expected is 1", expected, actual);
        }

        @Test
        public void shouldAddMoreElementThenInitialSizeWithotTroubles() throws Exception {
            //given
            int expected = 11;

            //when
            for (int i = 0; i < 11; i++) {
                list.add(i + 1);
            }
            int actual = list.size();

            //then

            assertEquals("ERROR!!! Actual result is wrong ! Expected is 1", expected, actual);
        }

        @Test
        public void shouldReturnLastAddedElement() throws Exception {
            //given
            int expected = 11;


            //when
            for (int i = 0; i < 11; i++) {
                list.add(i + 1);
            }
            int lastAddedIndex = list.size() - 1;
            int actual = list.get(lastAddedIndex);

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 1", expected, actual);
        }

        @Test(expected = IllegalArgumentException.class)
        public void shouldTryToGetZeroElementAndThrowException() {
            //when
            list.get(0);
        }

        @Test(expected = IllegalArgumentException.class)
        public void shouldTryToGetPositiveElementAndThrowException() {
            //when
            list.get(11);
        }

        @Test(expected = IllegalArgumentException.class)
        public void shouldTryToGetNegativeElementAndThrowException() {
            //when
            list.get(-1);
        }

        @Test
        public void testRemoveElementFromEmptyList() throws Exception {
            //given
            int expected = 0;
            //when
            list.remove();
            int actual = list.size();

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 0", expected, actual);
        }

        @Test
        public void testRemoveElementFromListAndReturnZero() throws Exception {
            //given
            int expected = 0;
            //when
            list.add(1);
            list.remove();
            int actual = list.size();

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 0", expected, actual);
        }

        @Test
        public void testRemoveSeconfElementFromListAndReturnOne() throws Exception {
            //given
            int expected = 1;
            //when
            list.add(1);
            list.add(2);
            list.remove();
            int actual = list.size();

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 1", expected, actual);
        }

        @Test
        public void testShouldIncreaseArrayLengh() throws Exception {
            //given
            int expected = 12;
            //when
            for (int i = 0; i < 9; i++) {
                list.add(i + 1);
            }

            int actual = list.getArrayLength();

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 12", expected, actual);
        }

        @Test
        public void testShouldDecreaseArrayLengh() throws Exception {
            //given
            int expected = 10;
            //when
            for (int i = 0; i < 9; i++) {
                list.add(i + 1);
            }
            list.remove();
            list.remove();
            int actual = list.getArrayLength();

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 12", expected, actual);
        }

        @Test
        public void testShouldDecreaseArrayLenghToTen() throws Exception {
            //given
            int expected = 10;
            //when
            for (int i = 0; i < 9; i++) {
                list.add(i + 1);
            }
            list.remove();
            list.remove();
            list.remove();
            list.remove();
            list.remove();
            list.remove();
            list.remove();
            int actual = list.getArrayLength();

            //then
            assertEquals("ERROR!!! Actual result is wrong ! Expected is 12", expected, actual);
        }
    }
}