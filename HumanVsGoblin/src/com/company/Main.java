package com.company;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Land land = new Land();

        //creating player and placing it on map
        Human player = new Human(land);
        System.out.println("");
        //creating goblin and placing it on map
        Goblin goblin1 = new Goblin(land);
        Goblin goblin2 = new Goblin(land);

        //sending to battle
        battle(player,goblin1,goblin2,land);
    }

    public static void battle(Human player, Goblin goblin, Goblin goblin2, Land land) {

        //continue the battle
        if (player.getHealth() > 0 && (goblin.getHealth() > 0||goblin2.getHealth()>0)) {
            //draw the land
            land.draw(player,goblin,goblin2,0,'0');
            //player moves
            move(player,0,goblin,goblin2,land);
            //goblin 1 then 2 moves
            move(goblin,goblin2,player,land);
            move(goblin2,goblin,player,land);
            //sends back to battle
            battle(player, goblin,goblin2, land);
        }
        //if the player won
        else if (player.getHealth() > 0) {
            System.out.println("The Knight has won!!!!");
        }//if the player lost
        else {
            System.out.println("The knight has lost!!!!!");
        }
    }

    //player moves
    public static void move(Human player, int walked, Goblin goblin, Goblin goblin2, Land land){
        try {
            Scanner scan = new Scanner(System.in);
            if (walked < player.getMove()) {
                System.out.println("You have " + (player.getMove() - walked) + " moves left \n " +
                        "(Type the i key to recieve instrucions)");
                String input = scan.next();
                char cHolder = input.toLowerCase().charAt(0);
                //test if play gave valid move if so move and re ask
                if( cHolder=='w'){
                    player.move(1,0,goblin,goblin2,land);
                    ++walked;
                }else if(cHolder == 's'){
                    player.move(-1,0,goblin,goblin2,land);
                    ++walked;
                }else if(cHolder == 'a'){
                    player.move(0,-1,goblin,goblin2,land);
                    ++walked;
                }else if(cHolder == 'd'){
                    player.move(0,1,goblin,goblin2,land);
                    ++walked;
                }else //for the soul perpose of not displaying error message
                    if(cHolder == 'H'||cHolder == 'i'||cHolder == 'e'||cHolder=='p'||cHolder == 'g'){}
                else{
                    System.out.println("Your input was invalid, please try again. ");
                }
                //draw the move
                land.draw(player,goblin,goblin2,0,cHolder);
                //recall method for more moves
                move(player, walked, goblin, goblin2,land);
            }
        }catch (Exception e ){
            System.out.println("Your input was invalid, please try again.");
            move(player, walked, goblin, goblin2,land);
        }
    }
    //goblins moves
    public static void move(Goblin goblin, Goblin goblin2, Human player, Land land){
            try{
                int latMov = ThreadLocalRandom.current().nextInt(0, goblin.getMove()+1);
                int lonMov = goblin.getMove() - latMov;

                int chance = ThreadLocalRandom.current().nextInt(1,6);
                //if already next to and is attacking
                if((goblin.getLongitude()-player.getLongitude()==1||goblin.getLongitude()-player.getLongitude()==-1) &&
                        (goblin.getLatitude()-player.getLatitude()==1||goblin.getLatitude()-player.getLatitude()==-1)
                        && (chance == 1 || chance ==2|| chance == 3 )) {
                    goblin.attack(player);

                }else{
                    switch (chance) {
                        case 1, 2, 3 -> {
                            //move towards the player
                            System.out.println("The Goblin has decided to move towards the hero.");
                            //move latitude //if player is above
                            if (player.getLatitude() < goblin.getLatitude()) {
                                //going the full way up
                                if (player.getLatitude() <= goblin.getLatitude() - latMov) {
                                    goblin.move(-latMov, 0, player, land);
                                }
                                //going partial way up
                                else {
                                    goblin.move(-(latMov - (player.getLatitude() - goblin.getLatitude())), 0, player, land);
                                }
                            }
                            // if the player is below
                            else if (player.getLatitude() > goblin.getLatitude()) {
                                //going the full way down
                                if (player.getLatitude() >= goblin.getLatitude() + latMov) {
                                    goblin.move(latMov, 0, player, land);
                                }
                                //going partial way down
                                else {
                                    goblin.move((latMov - (goblin.getLatitude() - player.getLatitude())), 0, player, land);
                                }
                            }
                            //move longitude//if player is left
                            if (player.getLongitude() < goblin.getLongitude()) {
                                //going the full way left
                                if (player.getLongitude() <= goblin.getLongitude() - lonMov) {
                                    goblin.move(0, -lonMov, player, land);
                                }
                                //going partial way left
                                else {
                                    goblin.move(0, -(lonMov - (goblin.getLongitude() - player.getLongitude())), player, land);
                                }
                            }
                            // if the player is right
                            else if (player.getLongitude() > goblin.getLongitude()) {
                                //going the full way right
                                if (player.getLongitude() >= goblin.getLongitude() + lonMov) {
                                    goblin.move(0, lonMov, player, land);
                                }
                                //going partial way right
                                else {
                                    goblin.move(0, (lonMov - (player.getLongitude() - goblin.getLongitude())), player, land);
                                }
                            }
                        }
                        case 4 -> {
                            //move Away from player
                            System.out.println("The Goblin is attempting to flee");
                            //move latitude //if player is above
                            if (player.getLatitude() < goblin.getLatitude()) {
                                //don't move down
                                if (goblin.getLatitude() == land.getLatitude()) {
                                    lonMov = lonMov + latMov;
                                }
                                //going all the way down
                                else if (goblin.getLatitude() + latMov <= land.getLatitude()) {
                                    goblin.move(latMov, 0, player, land);
                                }
                                //partial move
                                else {
                                    goblin.move((latMov + goblin.getLatitude() - land.getLatitude()), 0, player, land);
                                    lonMov = lonMov + (latMov - (latMov + goblin.getLatitude() - land.getLatitude()));
                                }
                            }
                            //if player is below
                            else if (player.getLatitude() > goblin.getLatitude()) {
                                //don't move up
                                if (goblin.getLatitude() == 1) {
                                    lonMov = lonMov + latMov;
                                }
                                //going all the way up
                                else if (goblin.getLatitude() - latMov >= 1) {
                                    goblin.move(-latMov, 0, player, land);
                                }
                                //going partial way up
                                else {
                                    goblin.move(-(latMov + goblin.getLatitude() - land.getLatitude()), 0, player, land);
                                    lonMov = lonMov + (latMov - (latMov + goblin.getLatitude() - land.getLatitude()));
                                }
                            }
                            //move longitude // if player is to the right
                            if (player.getLongitude() > goblin.getLongitude()) {
                                //don't move to the left move up if can
                                if (goblin.getLongitude() == 1) {
                                    goblin.move(lonMov, 0, player, land);
                                }
                                //going all the way left
                                else if (goblin.getLongitude() - lonMov >= 1) {
                                    goblin.move(0, -lonMov, player, land);
                                }
                                //partial move to the left
                                else {
                                    goblin.move(0, -(lonMov + (1 - goblin.getLongitude())), player, land);
                                    goblin.move(lonMov - (lonMov + (1 - goblin.getLongitude())), 0, player, land);
                                }
                            }
                            //if player is to the left
                            if (player.getLongitude() < goblin.getLongitude()) {
                                //don't move to the right move down if can
                                if (goblin.getLongitude() == land.getLongitude()) {
                                    goblin.move(-lonMov, 0, player, land);
                                }
                                //going all the way right
                                else if (goblin.getLongitude() + lonMov <= land.getLongitude()) {
                                    goblin.move(0, -lonMov, player, land);
                                }
                                //partial move to the right and move the remainder down if possible
                                else {
                                    goblin.move(0, -(lonMov - (land.getLongitude() - goblin.getLongitude())), player, land);
                                    goblin.move(-(lonMov - (lonMov - (land.getLongitude()) - goblin.getLongitude())), 0, player, land);
                                }
                            }
                        }
                        case 5 -> {
                            //move randomly
                            System.out.println("The Goblin has move in a strange manner.");
                            boolean up = ThreadLocalRandom.current().nextBoolean();
                            boolean right = ThreadLocalRandom.current().nextBoolean();
                            //if true move up else move down
                            if (!up) {
                                //if all moves can go up
                                if (goblin.getLatitude() - latMov >= 1) {
                                    goblin.move(latMov, 0, player, land);
                                }
                                //partial move up rest goes to longitude
                                else {
                                    goblin.move(latMov - (goblin.getLatitude() - 1), 0, player, land);
                                    lonMov = lonMov + (latMov - latMov - (goblin.getLatitude() - 1));
                                }
                            } else {
                                //if all moves can go down
                                if (goblin.getLatitude() + latMov <= land.getLatitude()) {
                                    goblin.move(-latMov, 0, player, land);
                                }
                                //partial move down rest goes to longitude
                                else {
                                    goblin.move(-(latMov - (land.getLatitude() - goblin.getLatitude())), 0, player, land);
                                    lonMov = lonMov + (latMov - latMov - (goblin.getLatitude() - 1));
                                }
                            }
                            //if true move right else move left
                            if (!right) {
                                //if all moves can go right
                                if (goblin.getLongitude() + lonMov <= land.getLongitude()) {
                                    goblin.move(0, lonMov, player, land);
                                }
                                //partial move right rest up if can
                                else {
                                    goblin.move(0, lonMov - (land.getLongitude() - goblin.getLongitude()), player, land);
                                    goblin.move(-(lonMov - (lonMov - (land.getLongitude() - goblin.getLongitude()))), 0, player, land);
                                }
                            } else {
                                //if all moves can go left
                                if (goblin.getLongitude() - lonMov >= 1) {
                                    goblin.move(-lonMov, 0, player, land);
                                }
                                //partial move to the left if not go down
                                else {
                                    goblin.move(0, -(lonMov - (land.getLongitude() - goblin.getLongitude())), player, land);
                                    goblin.move(lonMov - (lonMov - (land.getLongitude() - goblin.getLongitude())), 0, player, land);
                                }
                            }
                        }
                    }
                }
            }catch(Exception e){System.out.println("The goblins have become confused and can't move.");}
    }

}
