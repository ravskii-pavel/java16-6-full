package com.company;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by java on 13.12.2016.
 */
public class AListTest {
    AList list;

    @Before
    public void setUp(){
        list = new AList();
    }

    @Test
    public void shouldCheckThatListEmpty() throws Exception{
        //given
        int expected = 0;

        //when
        int actual = list.size();

        //then
        assertEquals("ERROR!!! Actual result is wrong! Expectet is 0", expected, actual);
    }

    @Test
    public void shouldAddElementAndReturnSizeOne() throws Exception {
        //given
        int expected = 1;

        //when
        list.add(5);
        int actual = list.size();
        //then
        assertEquals("ERROR!!! Actual result is wrong! Expectet is 1", expected, actual);
    }


    @Test
    public void shouldAddElementsAndReturnSizeTwo() throws Exception {
        //given
        int expected = 2;

        //when
        list.add(5);
        list.add(6);
        int actual = list.size();

        //then
        assertEquals("ERROR!!! Actual result is wrong! Expectet is 1", expected, actual);
    }

    @Test
    public void shouldAddMoreElementsThanInitialSizeWithoutTroubles() throws Exception {
        //given
        int expected = 11;

        //when
        for (int i = 0; i < 11; i++){
            list.add(i+1);
        }
        int actual = list.size();

        //then
        assertEquals("ERROR!!! Actual result is wrong! Expectet is 1", expected, actual);
    }

    @Test
    public void shouldReturnLastAddedElement(){
        //given
        int expected = 11;

        //when
            for (int i = 0; i < 11; i++){
                list.add(i+1);
        }
        int lastAddedIndex = list.size()-1;
        int actual = list.get(lastAddedIndex);

        //then
        assertEquals("ERROR!!! Actual result is wrong! Expectet is 1", expected, actual);
    }
    @Test(expected = IllegalArgumentException.class)
    public void shouldTryToGetZeroElementAndThrowException(){

        //when
        int actual = list.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTryToGetElevenElementAndThrowException(){

        //when
        int actual = list.get(11);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldTryToGetNegativeElementAndThrowException(){

        //when
        int actual = list.get(-1);
    }

    @Test
    public void shouldRemoveElementFromEmptyList() throws Exception {

        //given
        int expected = 0;

        //when
        list.remove();
        int actual = list.size();
        assertEquals("ERROR!!! Actual result is wrong! Expectet 0", expected, actual);
    }

    @Test
    public void shouldRemoveElementFromListAndReturnZero() throws Exception {

        //given
        int expected = 0;

        //when
        list.add(1);
        list.remove();
        int actual = list.size();
        assertEquals("ERROR!!! Actual result is wrong! Expectet 0", expected, actual);
    }
    @Test
    public void shouldRemoveSecondElementFromListAndReturnOne() throws Exception {

        //given
        int expected = 1;

        //when
        list.add(1);
        list.add(2);
        list.remove();
        int actual = list.size();
        assertEquals("ERROR!!! Actual result is wrong! Expectet 1", expected, actual);
    }

    @Test
    public void shouldIncreaseArrayLength() throws Exception {

        //given
        int expected = 12;

        //when
        for (int i = 0; i < 9; i++) {
            list.add(i + 1);
        }

        int actual = list.getArrayLength();
        assertEquals("ERROR!!! Actual result is wrong! Expectet 12", expected, actual);
    }

    @Test
    public void shouldDecreaseArrayLength() throws Exception {

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
        assertEquals("ERROR!!! Actual result is wrong! Expectet 10", expected, actual);
    }

    @Test
    public void shouldDecreaseArrayLengthToTen() throws Exception {

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
        assertEquals("ERROR!!! Actual result is wrong! Expectet 10", expected, actual);
    }
}