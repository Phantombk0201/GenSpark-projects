package com.company;

public class Potion {


    private int count;

    public Potion(){
        count = 1;
    }

    public int healthRestore(){return 25;}

    public int getCount() {return count;}
    public void add(int count) {this.count = this.count + count;}
    public void used(){this.count = count - 1;}

}
