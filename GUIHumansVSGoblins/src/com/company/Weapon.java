package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Weapon {
    private String type;
    private int strength;
    private int pierDam;
    private int slasDam;
    private int durability;

    public Weapon(){
        int ran = ThreadLocalRandom.current().nextInt(0,3);
        switch (ran) {
            case 0 -> {
                type = "Sword";
                strength = ThreadLocalRandom.current().nextInt(1, 4);//max stat 3 s, 2 p, 2 sl
                pierDam = ThreadLocalRandom.current().nextInt(1, 3);
                slasDam = ThreadLocalRandom.current().nextInt(1, 3);//min stat  1 s, 1 p, 1 sl
            }
            case 1 -> {
                type = "Axe";
                strength = ThreadLocalRandom.current().nextInt(2, 5);//max stat 4 s, 0 p, 3 sl
                pierDam = 0;
                slasDam = ThreadLocalRandom.current().nextInt(2, 4);//min stat  2 s, 0 p, 2 sl
            }
            case 2 -> {
                type = "Club";
                strength = ThreadLocalRandom.current().nextInt(3, 7);//max stat 6 s, 0 p, 0 sl
                pierDam = 0;
                slasDam = 0;                                                    //min stat  3 s, 0 p, 0 sl
            }
        }
    }
    public String getType(){
        return type;
    }
    public void setType(String type){this.type= type;}

    public int getStrength() {
        return strength;
    }
    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getPierDam() {
        return pierDam;
    }
    public void setPierDam(int pierDam) {
        this.pierDam = pierDam;
    }

    public int getSlasDam() {
        return slasDam;
    }
    public void setSlasDam(int slasDam) {
        this.slasDam = slasDam;
    }

    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }

    public String stats(){
        return "--------"+type + "---------," +
                "Strength: " + strength +"," +
                "Piercing Damage: "+ pierDam +"," +
                "Slash Damage: "+ slasDam +",";
    }
}
