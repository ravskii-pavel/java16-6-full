import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by ravskiy on 20.12.2016.
 */
public class PlayingCardsTest02 {

    @Test
    public void ShouldReturnVosmerkaPik(){
        //given
        int suitCard = 1;
        int valueCard = 8;
        String expected = "Восьмерка пик";

        //when
        String actual = Main.playingCards(suitCard, valueCard);

        //then
        assertEquals("Wrong actual number. Expected is Восьмерка пик", expected, actual);

    }
}
