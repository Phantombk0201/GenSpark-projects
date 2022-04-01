package com.company;


import lombok.Getter;

import java.util.Random;
import java.util.Scanner;
@Getter
public class Main {

    public static void main(String[] args) {

        Dragon dragon = new Dragon();
    }
    public static class Dragon{
        public Dragon(){
            // the story begins
            System.out.println("You are in a land full of dragons. In front of you, you see two caves.\n" +
                    "In one cave, the dragon is friendly and will share his treasure with you.\n" +
                    "The other dragon is greedy and hungry and will eat you on sight.\n" +
                    "Which cave will you go into? (1 or 2)");

            // a simple game adventure in the dragons lair
            Scanner input = new Scanner(System.in);
            int selection = input.nextInt();
            // randomizing the cave
            Random ran = new Random();
            int cave = ran.nextInt(2) + 1;

            // determining what happens
            System.out.println(DragonQuest(selection, cave));


        }
        public static String DragonQuest(int selection,int cave) {
            String outcome = "";

            // printing suspense
            String story = "You approach the cave...\n" +
                    "It is dark and spooky...\n" +
                    "A large dragon jumps out in front of you! \n" +
                    "He opens his jaws and...\n";
            try {
                //results
                if (selection == cave) {
                    outcome = "Gobbles you down in one bite!\n";
                } else {
                    outcome = "Offers to share his treasure with you!\n";
                }

            } catch (Exception e) {
                System.out.println("An error has occurred: " + e);
            }

            return outcome;
        }
    }
}



