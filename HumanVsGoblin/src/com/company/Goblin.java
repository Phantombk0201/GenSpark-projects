package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Goblin {
    private int health;
    private int strength;
    private int[] position = new int[2];
    private int move;
    Weapon weapon = new Weapon();
    Armor armor = new Armor();

    private int drop;
    private int pierArm;
    private int slasArm;

    public Goblin(Land land){
        health = ThreadLocalRandom.current().nextInt(5,15);
        strength =ThreadLocalRandom.current().nextInt(1,4);
        move = ThreadLocalRandom.current().nextInt(2,5);


        position[0] = ThreadLocalRandom.current().nextInt(1,land.getLatitude()+1);
        position[1] = ThreadLocalRandom.current().nextInt( 1,land.getLongitude()/2);

        //display stats
//        System.out.println("Goblin                      Armor \n" +
//                "Health:  "+ health + "              "+ armor.getStrength()+"\n" +
//                "Strength: " + strength +"           "+ armor.getPierDef()+"\n" +
//                "Move speed: " + move +"             "+ armor.getSlasDef()+"\n" +
//                "Position: " + Arrays.toString(position));
//
//        //print stats for weapon
//        weapon.printStats();
    }
    public void move(Human player, Land land){
        int lat = this.move;//heere
        int lon;
    }
    public void move(int lat, int lon, Human player,Land land){
        //if already died
        if(getHealth()<1){
            System.out.println("You sense the lingering will of the goblin desiring to move");
        }else{
            //invert the latitude move
            int move = Math.abs(lat) + Math.abs(lon);
            int tempLat = getLatitude()+lat;
            int tempLon = getLongitude()+lon;

            if(getMove()<move){
                System.out.println("");
            }else if(getLatitude()+lat==player.getLatitude()
                    && getLongitude()+lon==player.getLongitude()){
                attack(player);
            }else if (tempLat > land.getLatitude()
                    || tempLat< 1){
                System.out.println("");
            }else if (tempLon > land.getLongitude()
                    || tempLon< 1) {
                System.out.println("");
            }else{
                setPosition(lat, lon);
            }
        }
    }
    public void attack(Human player){

        player.setHealth(strength+weapon.getStrength(), weapon.getPierDam(),weapon.getSlasDam());
        System.out.println("You were attack by a goblin, you have " + player.getHealth() + "hp remaining");
        if(player.getHealth()<1){
            player.death();
        }
    }

    public void death(){
        setMove(0);
        setStrength(0);
        setPosition(0,0);
        System.out.println("The goblin has died!!!");
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int gStrength, int wSlash, int wPierce) {
        int loss =0;
        if(gStrength-armor.getStrength()>0){
            loss = loss + (gStrength-armor.getStrength());
        }
        if(wSlash-armor.getSlasDef()>0){
            loss = loss +(wSlash-armor.getSlasDef());
        }
        if(wPierce - armor.getPierDef()>0){
            loss = loss + (wPierce - armor.getPierDef());
        }
        if(loss == 0){
            System.out.println("Your weapon bounced of the goblins armor");
        }
        health = health -loss;
    }

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int[] getPosition() {
        return position;
    }
    public void setPosition(int[] position) {
        this.position = position;
    }
    public void setPosition(int lat, int lon) {
        position[0] = position[0] + lat;
        position[1] = position[1] + lon;
    }
    public int getLatitude(){return position[0];}
    public int getLongitude(){return position[1];}

    public int getMove() {
        return move;
    }
    public void setMove(int move) {
        this.move = move;
    }

}
