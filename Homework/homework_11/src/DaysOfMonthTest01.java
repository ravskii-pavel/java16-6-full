import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ravskiy on 20.12.2016.
 */

public class DaysOfMonthTest01 {

    @Test
    public void ShouldReturnTwentyNine(){
        //given
        int num = 2;
        String expected = "29 дней";
        //when
        String actual = Main.daysOfMonth(num, 2016);

        //then
        assertEquals("Wrong actual number. Expected is 29 дней", expected, actual);

    }
    @Test
    public void ShouldReturnTwentyEight(){
        //given
        int num = 2;
        String expected = "28 дней";
        //when
        String actual = Main.daysOfMonth(num, 2015);

        //then
        assertEquals("Wrong actual number. Expected is 28 дней", expected, actual);

    }

    @Test
    public void ShouldReturnZero(){
        //given
        int num = 14;
        String expected = "zero";
        //when
        String actual = Main.daysOfMonth(num, 2016);

        //then
        assertEquals("Wrong actual number. Expected is zero", expected, actual);

    }
    @Test
    public void ShouldReturnThirtyOne(){
        //given
        int num = 12;
        String expected = "31 день";
        //when
        String actual = Main.daysOfMonth(num, 2015);

        //then
        assertEquals("Wrong actual number. Expected is zero", expected, actual);

    }

}
