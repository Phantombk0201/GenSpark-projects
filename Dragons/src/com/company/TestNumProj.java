package com.company;

import org.junit.*;

import static org.junit.Assert.assertEquals;

public class TestNumProj {
    @Test
    public void TestNumProj(){
        String outcome = "Gobbles you down in one bite!\n";
        String outcome2 = "Offers to share his treasure with you!\n";
        //Main.Dragon dragon = new Main.Dragon();
        boolean getTreasure = outcome2.equals(Main.Dragon.DragonQuest(1, 2));
        boolean died = outcome.equals(Main.Dragon.DragonQuest(2, 2));
        assert(getTreasure);
        assert(died);

    }
}
