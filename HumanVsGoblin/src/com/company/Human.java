package com.company;



import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;


public class Human {

    //player stats
    private int health;
    private int strength;
    private int[] position = new int[2];
    private int move;

    //inventory
    Bag bag = new Bag();

    //weapon and armor
    private Weapon weapon = new Weapon();
    private Armor armor = new Armor();




    public Human(Land land){
        health = ThreadLocalRandom.current().nextInt(10,25);
        strength = ThreadLocalRandom.current().nextInt(3,5);
        move = ThreadLocalRandom.current().nextInt(2,4);
        position[0] = ThreadLocalRandom.current().nextInt(1,land.getLatitude()+1);
        position[1] = ThreadLocalRandom.current().nextInt(land.getLongitude()/2,land.getLongitude()+1);


//        //display stats
//        System.out.println("Human \n" +
//                "Health:  "+ health + "\n"+
//                "Strength: " + strength +"\n"+
//                "Move speed: " + move +"\n"+
//                "Position: " + Arrays.toString(position));
//
//        weapon.printStats();

    }
    public void move(int lat, int lon, Goblin goblin,Goblin goblin2,Land land){
        //invert the latitude move
        lat = lat *-1;
        int move = Math.abs(lat) + Math.abs(lon);
        int tempLat = getLatitude()+ lat;
        int tempLon = getLongitude() + lon;

        //if you can't move that far
        if(getMove()<move){
            System.out.println("You can't move that far try again");
        }
        //if you would be moving to the goblins position
        else if(tempLat==goblin.getLatitude()
                && tempLon==goblin.getLongitude()){
            System.out.println("You attack the goblin the  Positioned there!");
            attack(goblin);
        } else if(tempLat==goblin2.getLatitude()
                && tempLon==goblin2.getLongitude()){
            System.out.println("You attack the goblin the  Positioned there!");
            attack(goblin2);
        }
        //if you would be moving out of bounds
        else if (tempLat > land.getLatitude()
                || tempLat< 1){
            System.out.println("You can't move that far on the latitude.");
        }
        else if (tempLon > land.getLongitude()
                || tempLon< 1) {
            System.out.println("You can't move that far on the longitude.");
        }
        //if you can move there
        else{
            setPosition(lat, lon);
        }
    }
    public void attack(Goblin goblin){
        goblin.setHealth(strength+weapon.getStrength(), weapon.getPierDam(),weapon.getSlasDam());
        if(goblin.getHealth()<1){
            goblin.death();
        }
    }
    public void death(){
        System.out.println("It looks like you adventure has come to an end!");
        setMove(0);
        setStrength(0);
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
            System.out.println("The goblins weapon bounced of your armor");
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
        if(armor.getHeavy()){return move - 1;}else{
        return move;}
    }
    public void setMove(int move) {
        this.move = move;
    }

    public Weapon getWeapon(){return weapon;}
    public Armor getArmor(){return armor;}

    public void takePotion(Potion potion){
        if(potion.getCount()>0){
            health = health + potion.healthRestore();
            potion.used();}
        else{
            System.out.print(",but it would appear you have run out of potions.");
        }
    }

    public void addPotion(Potion potion){
        potion.add(1);
    }
}
