package com.company;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestNumProj {
    @Test
    public void TestNumProj(){
        String guess = Main.HGuess(15,15);
        String guess2 = Main.HGuess(16,15);
        String guess3 = Main.HGuess(14,15);
        String guess4 = Main.HGuess(15646574,15646574);
        String guess5 = Main.HGuess(15646574,15646572);
        String guess6 = Main.HGuess(15646574,15646575);
        boolean g1 = guess.equals("correct");
        boolean g2 =guess2.equals("low");
        boolean g3 =guess3.equals("high");
        boolean g4 =guess4.equals("correct");
        boolean g5 =guess5.equals("low");
        boolean g6 =guess6.equals("high");
        assert(g1);
        assert(g2);
        assert(g3);
        assert(g4);
        assert(g5);
        assert(g6);
    }
}
