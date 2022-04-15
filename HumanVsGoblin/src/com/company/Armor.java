package com.company;

import java.util.concurrent.ThreadLocalRandom;

public class Armor {
    private String type;
    private int strength;
    private int pierDef;
    private int slasDef;
    private int durability;
    private boolean heavy=false;

    public Armor(){
        int ran = ThreadLocalRandom.current().nextInt(0,3);
        switch (ran) {
            case 0 -> {
                type = "Chain mail";
                strength = ThreadLocalRandom.current().nextInt(1, 4);//max stat 3 s, 0 p, 3 sl
                pierDef = 0;
                slasDef = ThreadLocalRandom.current().nextInt(2, 4);//min stat  1 s, 0 p, 2 sl
            }
            case 1 -> {
                type = "Plate";
                strength = ThreadLocalRandom.current().nextInt(2, 6);//max stat 5 s, 3 p, 3 sl
                pierDef = ThreadLocalRandom.current().nextInt(2, 4);
                slasDef = ThreadLocalRandom.current().nextInt(2, 4);//min stat  2 s, 2 p, 2 sl
                heavy = true;
            }
            case 2 -> {
                type = "Gibson";
                strength = ThreadLocalRandom.current().nextInt(3, 7);//max stat 6 s, 0 p, 0 sl
                pierDef = 0;
                slasDef = 0;                                                    //min stat  3 s, 0 p, 0 sl
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

    public int getPierDef() {
        return pierDef;
    }
    public void setPierDef(int pierDef) {
        this.pierDef = pierDef;
    }

    public int getSlasDef() {
        return slasDef;
    }
    public void setSlasDef(int slasDef) {
        this.slasDef = slasDef;
    }

    public int getDurability() {
        return durability;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }

    public boolean getHeavy(){return heavy;}
    public void setHeavy(boolean heavy){this.heavy = heavy;}
}
