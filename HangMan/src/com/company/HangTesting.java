package com.company;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
public class HangTesting {
    @Test
    public void HangTesting(){
        HiddenWord word = new HiddenWord("tEst");
        FillOutTheBlank blank = new FillOutTheBlank();
        blank.setBlank("test");
        //testing if the word contains the letter or not ignoring the case
        boolean wTest1 = word.guess('c');
        boolean wTest2 = word.guess('t');
        boolean wTest3 = word.guess('E');
        boolean wTest4 = word.guess('S');

        //testing if it retrieves the right letter
        boolean wTest5 = word.getChar(0).equals('t');
        boolean wTest6 = word.getChar(1).equals('e');
        boolean wTest7 = word.getChar(2).equals('t');

        //testing if the guess has been made or not ignoring case
        boolean bTest1 = blank.guess('c');
        boolean bTest2 = blank.guess('c');
        boolean bTest3 = blank.guess('T');
        boolean bTest4 = blank.guess('t');



        assertEquals(false, wTest1);
        assertEquals(true, wTest2);
        assertEquals(true, wTest3);
        assertEquals(true, wTest4);

        assertEquals(true, wTest5);
        assertEquals(true, wTest6);
        assertEquals(false, wTest7);

        assertEquals(true, bTest1);
        assertEquals(false, bTest2);
        assertEquals(true, bTest3);
        assertEquals(false, bTest4);



    }
}
