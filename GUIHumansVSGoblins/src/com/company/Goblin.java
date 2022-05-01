package com.company;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Goblin {
    private int[] position = new int[2];
    private int[] maxDistance = new int[2];
    private boolean dead = false;
    private String gMessage ="A New goblin has arrived";

    private int health,strength,move;
    private Weapon weapon = new Weapon();
    private Armor armor = new Armor();

    private char facing = 'D';

    Goblin(Land land){
        maxDistance = land.getLatLong();
        health = ThreadLocalRandom.current().nextInt(5,15);
        strength =ThreadLocalRandom.current().nextInt(1,4);
        move = ThreadLocalRandom.current().nextInt(2,5);

        position[0] = ThreadLocalRandom.current()
                .nextInt(1,land.getLatitude()+1);
        position[1] = ThreadLocalRandom.current()
                .nextInt( 1,land.getLongitude()/2);

        System.out.println(getStats());
    }


    public boolean setxCoordinate(int xCoordinate){
        if(maxDistance[0]>=xCoordinate && xCoordinate>=0){
            position[0] = xCoordinate;
            return true;
        }else{return false;}
    }
    public boolean setyCoordinate(int yCoordinate){
        if(maxDistance[1]>=yCoordinate && yCoordinate>=0){
            position[1] = yCoordinate;
            return true;
        }else{return false;}
    }

    public int getHealth(){return health;}
    public void setHealth(int playStren,int playPier,int playSlash){
        int loss=0;

        playStren =playStren -armor.getStrength();
        playPier =playPier- armor.getPierDef();
        playSlash=playSlash- armor.getSlasDef();

        if(playStren>0){loss = loss +playStren;}
        if(playPier>0){loss = loss + playPier;}
        if(playSlash>0){loss = loss +playSlash;}

        health = health -loss;
        if(health<0){
            move =0;
            facing = 'P';
            dead = true;}
    }

    public char getFacing() {return facing;}
    public void setFacing(char facing) {this.facing = facing;}

    public int getxCoordinate() {return position[0];}
    public int getyCoordinate() {return position[1];}

    public String getStats(){
        return "_____Goblin______," +
                "Health:  "+ health + ","+
                "Strength: " + strength +","+
                "Move speed: " + move +","+
                "Position: X:" + (position[0]+1) + " Y:" + (position[1]+1);
    }
    public String getGMessage(){return gMessage;}
    public void setGMessage(String message){gMessage = message;}

    public Weapon getWeapon(){return weapon;}
    public Armor getArmor(){return armor;}

    public void move(Human player, Land land){
        int xMove=ThreadLocalRandom.current().nextInt(0, move+1);
        int yMove = move - xMove;
        int chance = ThreadLocalRandom.current().nextInt(1,11);

        //if already next to and is attacking
        if((position[0]-player.getxCoord()==1||position[0]-player.getxCoord()==-1) &&
                (position[1]-player.getyCoord()==1||position[1]-player.getyCoord()==-1)
                && (chance == 1 || chance ==2|| chance == 3 )) {
            attack(player);
        }else{
            switch (chance){
                //move towards the player
                case 1,2,3,4,5,6,7 ->{
                    //if player is above
//                    System.out.println(Arrays.toString(position));
                    gMessage = "The goblin moves towards you.";
                    if(yMove>0) {
                        if (player.getyCoord() < position[1]) {
                            //if the goblin can move all the way up
                            if (player.getyCoord() <= position[1] - yMove) {
                                move(0, -yMove, player, land);
                            } else {// y = 2(player)-5(goblin)
                                int y = player.getyCoord() - position[1];
                                move(0, y, player, land);
                                xMove = xMove + (yMove + y);//the remainder goes to the x move
                            }
                        }
                        // the player is below
                        else if (player.getyCoord() > position[1]) {
                            //go the full way down
                            if (player.getyCoord() >= position[1] + yMove) {
                                move(0, yMove, player, land);
                            } else {//y =2(goblin)-5(player)
                                int y = position[1] - player.getyCoord();
                                move(0, -y, player, land);
                                xMove = xMove + (yMove + y);//the remainder goes to the x move
                            }
                        }
                    }
                    if(xMove>0) {
                        //if player is left
                        if (player.getxCoord() < position[0]) {
                            //going the full way left
                            if (player.getxCoord() <= position[0] - xMove) {
                                move(-xMove, 0, player, land);
                            } else {//x = 2(player) -5(goblin)
                                int x = player.getxCoord() - position[0];
                                move(x, 0, player, land);
                            }
                        }
                        //if the player is to the right
                        else if (player.getxCoord() > position[0]) {
                            //going the full way right
                            if (player.getxCoord() >= position[0] + xMove) {
                                move(xMove, 0, player, land);
                            } else {//x = 2(goblin)-5(player)
                                int x = position[0] - player.getxCoord();
                                move(-x, 0, player, land);
                            }
                        }
                    }
                }
                //move away from player
                case 8 ->{
//                    System.out.println(Arrays.toString(position));
                    gMessage = "The goblin moves away from you.";
                    //if player is above
                    if(player.getyCoord()<position[1]){
                        //if cant move all the way down
                        if(maxDistance[1]<position[1]+yMove){
                            int y = yMove-((position[1]+yMove)-maxDistance[1]);
                            move(0,y,player,land);
                        }else{move(0,yMove,player,land);}
                    }
                    //if player is below
                    else if(player.getyCoord()>position[1]){
                        //if cant move all the way up
                        if(0>position[1]-yMove){
                            int y =yMove+(position[1]-yMove);
                            move(0,-y,player,land);
                        }else{move(0,-yMove,player,land);}
                    }
                    //player is to the left
                    if(player.getxCoord()<position[0]){
                        //if cant move all the way right
                        if(maxDistance[0]<position[0]+xMove){
                            int x = xMove-((position[1]+xMove)-maxDistance[1]);
                            move(x,0,player,land);
                        }else{move(xMove,0,player,land);}
                    }
                    //player is to the right
                    else if(player.getxCoord()>position[0]){
                        //cant move all the way left
                        if(0>position[0]-xMove){
                            int x =xMove+(position[1]-xMove);
                            move(-x,0,player,land);
                        }else{move(-xMove,0,player,land);}
                    }
                }
                //move randomly
                case 9,10 ->{
//                    System.out.println(Arrays.toString(position));
                    gMessage ="The Goblin moves in a strange manner. ";
                    boolean up = ThreadLocalRandom.current().nextBoolean();
                    boolean right = ThreadLocalRandom.current().nextBoolean();
                    //moving up
//                    System.out.println(up + "," +right);
                    if(up){
                        //if cant move all the way up
                        if(0>position[1]-yMove){
                            int y =yMove+(position[1]-yMove);
                            move(0,-y,player,land);
                        }else{move(0,yMove,player,land);}
                    }//else moving down
                    else{
                        //if cant move all the way down
                        if(maxDistance[1]<position[1]+yMove){
                            int y = yMove-((position[1]+yMove)-maxDistance[1]);
                            move(0,y,player,land);
                        }else{move(0,yMove,player,land);}
                    }
                    //moving right
                    if(right){
                        //if cant move all the way right
                        if(maxDistance[0]<position[0]+xMove){
                            int x = xMove-((position[1]+xMove)-maxDistance[1]);
                            move(x,0,player,land);
                        }else{move(xMove,0,player,land);}
                    }//else moving left
                    else{
                        //cant move all the way left
                        if(0>position[0]-xMove){
                            int x =xMove+(position[1]-xMove);
                            move(x,0,player,land);
                        }else{move(xMove,0,player,land);}
                    }
                }
            }
        }
//        System.out.println(gMessage);
//        System.out.println(Arrays.toString(position));
    }
    public void move(int x, int y, Human player, Land land){
        //if already died
        if(getHealth()<1){
            System.out.println("You sense the lingering will of the goblin desiring to move");
        }else{
            if((player.getxCoord()==position[0]+x)
                    &&(player.getyCoord()==position[1]+y)){
                attack(player);
            }else {
                position[0] = position[0]+x;
                position[1] = position[1]+y;
            }
        }
    }

    public void attack(Human player){
        player.setHealth(strength + weapon.getStrength(),weapon.getPierDam(),weapon.getSlasDam());
        gMessage = "Goblin attack you";
    }

    public boolean getDeath(){return dead;}
}
