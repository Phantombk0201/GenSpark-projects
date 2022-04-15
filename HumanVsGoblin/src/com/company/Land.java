package com.company;

public class Land {
    private int latitude = 10;
    private int longitude = 10;
    private int terrain;


    //draws positions
    public void draw(int pPosition, int firGobPos,int secGobPos, int longitude){
        ++longitude;
        if(longitude <= this.longitude){
            if(longitude == pPosition){
                System.out.print(" P ");
            }else
            if(longitude == firGobPos||longitude==secGobPos){
                System.out.print(" G ");
            }else{
                System.out.print(" X ");
            }
            draw(pPosition,firGobPos, secGobPos,longitude);
        }
    }
    //individual layers
    public void draw(Human player, Goblin goblin,Goblin goblin2, int layer, char dis){
        int plaPos = 0;
        int firGobPos = 0;
        int secGobPos = 0;

        if(layer<latitude){
            //determine if the player and enemy are on this layer
            if(layer + 1 == player.getLatitude() ){
                plaPos = player.getLongitude();
            }
            if(layer +1 == goblin.getLatitude()){
                firGobPos = goblin.getLongitude();
            }
            if(layer +1 == goblin2.getLatitude()){
                secGobPos = goblin2.getLongitude();
            }

            //draw this layer
            draw(plaPos,firGobPos,secGobPos,0);
            //displaying additional info
            System.out.print("           ");
            //display equipment
            if(dis=='e'){
                switch (layer){
                    case 0 ->{
                        System.out.print("-----------------Equipment-------------------");
                    }
                    case 1 -> {
                        System.out.print("------"+player.getWeapon().getType()+"------");
                        System.out.print("      ------"+player.getArmor().getType()+"------");
                    }
                    case 2 -> {
                        System.out.print("Strength: "+ player.getWeapon().getStrength());
                        System.out.print("          Strength: "+ player.getArmor().getStrength());
                    }
                    case 3 -> {
                        System.out.print("Slash Damage: " + player.getWeapon().getSlasDam());
                        System.out.print("      Slash Defence: " + player.getArmor().getSlasDef());
                    }
                    case 4 -> {
                        System.out.print("Pierce Damage: " + player.getWeapon().getPierDam());
                        System.out.print("     Pierce Defence: " + player.getArmor().getPierDef());
                    }
                }
            }
            //display character status
            else if(dis=='p'){
                switch (layer){
                    case 1 ->{
                        System.out.print("-----------Player Status----------");
                    }
                    case 2 -> System.out.print("------Human------");
                    case 3 -> System.out.print("Health:  "+ player.getHealth());
                    case 4 -> System.out.print("Strength: " + player.getStrength());
                    case 5 -> System.out.print("Move speed: " + player.getMove());
                }
            }
            //display goblin status
            else if(dis=='g'){
                switch (layer){
                    case 1 ->System.out.print("------------Goblin Status--------");
                    case 2 -> System.out.print("------Goblin1------             ------Goblin2------ ");
                    case 3 -> System.out.print("Health:  "+ goblin.getHealth()+"                      Health:  "+ goblin2.getHealth());
                    case 4 -> System.out.print("Strength: " + goblin.getStrength()+"                     Strength: " + goblin2.getStrength());
                    case 5 -> System.out.print("Move speed: " + goblin.getMove()+"                   Move speed: " + goblin2.getMove());
                    case 6 -> System.out.print("Armor: " + goblin.armor.getType()+"                     Armor: " + goblin2.armor.getType());
                    case 7 -> System.out.print("Weapon: " + goblin.weapon.getType()+"                     Weapon:  " + goblin2.weapon.getType());
                }
            }
            //display info about game
            else if(dis =='i'){
                if(layer ==0){System.out.print("You are and Adventurer that is traversing the land to slay the evil goblins");}
                if(layer ==1){System.out.print("Use WASD keys to decide which direction to go.");}
                if(layer ==2){System.out.print("Use P key to see the Player Status, or G Key to see Goblin Status");}
                if(layer ==3){System.out.print("Use E key to see the Equipment");}
            }
            //use potion
            else if(dis =='h'){
                if(layer == 0){System.out.print("You attempt to you one of your potions");
                    int slot = player.bag.getPotion(0);
                    player.takePotion((Potion) player.bag.getItem(slot));
                    dis = 'p';
                }

            }
            //increment the layer and redraw
            System.out.println("");

            draw(player,goblin,goblin2,++layer,dis);
        }
    }


    public int getLatitude() {
        return latitude;
    }
    public void setLatitude(int latitude) {
        this.latitude = latitude;
    }

    public int getLongitude() {
        return longitude;
    }
    public void setLongitude(int longitude) {
        this.longitude = longitude;
    }

    public int getTerrain() {
        return terrain;
    }
    public void setTerrain(int terrain) {
        this.terrain = terrain;
    }
}
