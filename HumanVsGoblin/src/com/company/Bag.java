package com.company;

public class Bag {
    private int items;
    private Object[] bag = new Object[6];

    public Bag(){
        //start with one potion
        Potion potions = new Potion();
        bag[0] = potions;

        //test weapon holding
    }
    //test if bag slot has item
    public boolean hasItem(int slot){
        if (bag[slot] instanceof Potion) {
            return true;
        }else  if (bag[slot] instanceof Weapon){
            return true;
        }else  if (bag[slot] instanceof Armor){
            return true;
        }
        return false;
    }

    //get item for specific spot
    public Object getItem(int slot){
        if(hasItem(slot)){
            return bag[slot];
        }
        return "Is Empty";
    }
    public int getPotion(int slot){
        if (bag[slot] instanceof Potion) {
            return slot;
        }else if(slot<bag.length){
            getItem(++slot);
        }
        return -1;
    }

    public int slots(){return bag.length;}
}
