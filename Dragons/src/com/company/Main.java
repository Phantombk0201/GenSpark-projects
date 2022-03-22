package com.company;


import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // a simple game adventure in the dragons lair
        Scanner input = new Scanner(System.in);
        // the story begins
        System.out.println("You are in a land full of dragons. In front of you, you see two caves.\n" +
                "In one cave, the dragon is friendly and will share his treasure with you.\n" +
                "The other dragon is greedy and hungry and will eat you on sight.\n" +
                "Which cave will you go into? (1 or 2)");
        int selection = input.nextInt();
        // randomizing the cave
        Random ran = new Random();
        int cave = ran.nextInt(2) +1;
        System.out.print(cave);
        // determining what happens
        String outcome = "";
        if (selection == cave) {
            outcome = "Gobbles you down in one bite!\n";
        } else {
            outcome = "Offers to share his treasure with you!\n";
        }
        // printing suspense
        String story = "\nYou approach the cave...\n" +
                "It is dark and spooky...\n" +
                "A large dragon jumps out in front of you! \n" +
                "He opens his jaws and...\n" ;

        //results
        System.out.println(story + outcome);
    }
}
