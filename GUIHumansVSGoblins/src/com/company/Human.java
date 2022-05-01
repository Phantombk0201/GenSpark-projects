package com.company;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Human {
    private boolean dead = false;

    private int health;
    private int strength;
    private Weapon weapon = new Weapon();
    private Armor armor = new Armor();

    private int[] position = new int[2];
    private int move;

    private int[] maxDistance = new int[2];
    private int[] enemyLocation = new int[6];

    private char facing = 'S';
    Human(Land land){
        health = ThreadLocalRandom.current().nextInt(10,25);
        strength = ThreadLocalRandom.current().nextInt(3,5);
        move = ThreadLocalRandom.current().nextInt(2,4);
        position[0] = ThreadLocalRandom.current()
                .nextInt(1,land.getLatitude()+1);
        position[1] = ThreadLocalRandom.current()
                .nextInt(land.getLongitude()/2,land.getLongitude()+1);
        maxDistance = land.getLatLong();

        //display stats
        System.out.println(getStats());
    }

    public int setxCoord(int xCoordinate){//checks each enemy location enemy1:0,1 enemy2:2,3 enemy3:4,5
        //returning who attacking
        if (enemyLocation[0]==xCoordinate &&
                enemyLocation[1] == position[1]){return 1;}
        else if (enemyLocation[2]==xCoordinate &&
                enemyLocation[3] == position[1]){return 2;}
        else if (enemyLocation[4]==xCoordinate &&
                enemyLocation[5] == position[1]){return 3;}

        //check if inside map
        else if(maxDistance[0]>=xCoordinate && xCoordinate>=0){
            position[0] = xCoordinate;
            return 0;
        }else{return -1;}

    }
    public int setyCoord(int yCoordinate){//checks each enemy location enemy1:0,1 enemy2:2,3 enemy3:4,5
        //returning who attacking
        if (enemyLocation[1]==yCoordinate &&
                enemyLocation[0]==position[0]){return 1;}
        else if (enemyLocation[3]==yCoordinate &&
                enemyLocation[2]==position[0]){return 2;}
        else if (enemyLocation[5]==yCoordinate &&
                enemyLocation[4]==position[0]){return 3;}

        //check if inside map
        else if(maxDistance[1]>=yCoordinate && yCoordinate>=0){
            position[1] = yCoordinate;
            return 0;
        }
        else{return -1;}
    }

    public void attack(Goblin attackEdenemy){
        attackEdenemy.setHealth(strength+ weapon.getStrength(),weapon.getPierDam(),weapon.getSlasDam());
        if(health<0){
            move =0;
            dead = true;}
    }
    public void setHealth(int enemStren,int enemPier,int enemSlash){
        int loss=0;
        enemStren =enemStren -armor.getStrength();
        enemPier =enemPier- armor.getPierDef();
        enemSlash=enemSlash- armor.getSlasDef();
        if(enemStren>0){loss = loss +enemStren;}
        if(enemPier>0){loss = loss + enemPier;}
        if(enemSlash>0){loss = loss +enemSlash;}

        health = health -loss;
        if(health<1){
            dead = true;
        }
    }

    public int getMove(){return move;}

    public int getxCoord() {return position[0];}
    public int getyCoord() {return position[1];}

    public char getFacing() {return facing;}
    public void setFacing(char facing) {this.facing = facing;}

    public void setEnemyLocation(Goblin enemy1, Goblin enemy2, Goblin enemy3){
        enemyLocation[0] = enemy1.getxCoordinate();
        enemyLocation[1] = enemy1.getyCoordinate();
        enemyLocation[2] = enemy2.getxCoordinate();
        enemyLocation[3] = enemy2.getyCoordinate();
        enemyLocation[4] = enemy3.getxCoordinate();
        enemyLocation[5] = enemy3.getyCoordinate();
    }

    public Weapon getWeapon(){return weapon;}
    public Armor getArmor(){return armor;}

    public boolean getDeath(){return dead;}
    public String getStats(){
        return "_____Human______," +
                "Health:  "+ health + ","+
                "Strength: " + strength +","+
                "Move speed: " + move +","+
                "Position: X:" + position[0] + " Y:" + position[1];
    }
}
