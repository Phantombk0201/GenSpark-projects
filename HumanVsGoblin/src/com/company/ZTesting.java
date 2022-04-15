package com.company;

import org.junit.Test;

public class ZTesting {
    @Test
    public void ZTesting(){
        boolean test = true;

        Land land = new Land();
        Human player = new Human(land);
        Goblin goblin = new Goblin(land);
        Goblin goblin2 = new Goblin(land);
        //adding health for tests
//        int slot = player.bag.getPotion(0);
//        player.takePotion((Potion) player.bag.getItem(slot));
//        land.draw(player,goblin,0,'p');System.out.println("");
//
//        player.takePotion((Potion) player.bag.getItem(slot));
//        land.draw(player,goblin,0,'p');System.out.println("");
//
//        player.addPotion((Potion) player.bag.getItem(slot));
//        land.draw(player,goblin,0,'p');System.out.println("");
//
//        player.takePotion((Potion) player.bag.getItem(slot));
//        land.draw(player,goblin,0,'p');System.out.println("");

        //fixing the position of the goblin and human
        int[] pP = new int[]{3,3};
        int[] gP = new int[]{3,2};
        int[] g2P= new int[]{3,4};
        player.setPosition(pP);
        goblin.setPosition(gP);
        goblin2.setPosition(g2P);
        land.draw(player,goblin,goblin2,0,'p');System.out.println("");
        player.move(0,1,goblin,goblin2,land);
//        land.draw(player,goblin,goblin2,0,'e');System.out.println("");
//        land.draw(player,goblin,goblin2,0,'g');System.out.println("");


        Main.move(goblin,goblin2,player,land);
        land.draw(player,goblin,goblin2,0,'g');System.out.println("");
        Main.move(goblin,goblin2,player,land);
        land.draw(player,goblin,goblin2,0,'g');System.out.println("");
        Main.move(goblin,goblin2,player,land);
        land.draw(player,goblin,goblin2,0,'g');System.out.println("");
        Main.move(goblin,goblin2,player,land);

    }
}
