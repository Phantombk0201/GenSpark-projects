package com.company;

import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {

    public static void main(String[] args) {

        // a simple game guessing game
        Scanner input = new Scanner(System.in);
        // the story begins
        System.out.println("HElLO hUMaN mY NaME Is G.\n" +
                "I hAvE DeCIDe oT PLaY a GAmE WItH YoU. \n" +
                "If YOu WiN YOU gO HOMe BuT iF i WIn YoU wiLl bEcoME My NEw ToY FOR EvER.\n" +
                "DO YOu WaNT tO PlAY,[INSERT UNIMPORTANT NAME]? (1 FOR YES or 2 FOR NO)");
        int selection = input.nextInt();
        // randomizing the number
        int num = ThreadLocalRandom.current().nextInt(1,20);

        //Encapusolation the game so it can be replayed
        do {
            //creating all the vairables
            int count = 6;
            boolean easy = true;
            boolean won;

            // Tell the player they have no choose
            if (selection != 1) {
                System.out.println("YOu HaVE No ChOoSE iN ThE MatTer.\n" +
                        "i JUst WAnTEd yOU To FeeL lIkE YOU dID.\n");
            }

            //creating a second guess just in case they decide to try
            long num2 = ThreadLocalRandom.current().nextInt(1,99999999);

            System.out.println("i IN AlL mY PrOceSSiNG poWer HavE PIcK A NuMBer bEtWeEN 1 and 999999999999999999999999999999999999999\n" +
                    "yOU HAvE 6 GuESs tO gEt It RiGhT.\n" +
                    "WHaT Is YoU FiRsT GuEsS? (Either Pick a Number or type NO)");

            //if they want to play the hard mode
            while (input.hasNextLong()) {
                won = false;
                easy = false;
                long guess = input.nextLong();
                if (guess < num2) {
                    System.out.println("HAHaHahahAH YouR GUEss wAs FAr ToO loW.");
                } else if (guess > num2) {
                    System.out.println("HAHaHahahAH YouR GUEss wAs FAr ToO HiGh.");
                } else if (guess == num2) {
                    System.out.println("In iNcONcEIvaBLE, YoU MUsT HAve CheATeD.\n" +
                            ".........\n" +
                            "HaS SUcH YoU HaVe LOst.");
                    won = true;
                }
                count--;
                if (count == 0 && !won) {
                    System.out.println("It WOuLd APPeAr YOu HAve LOst.");
                    System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
                    break;
                }
            }
            //just to make the easy mode run proper
            input.next();
            int giv = 1;
            //if they refuse to play the hard mode
            while (easy) {

                won = false;
                if(giv == 1) {
                    System.out.println("HaVE YoU AlREaDy GIVEn Up?\n" +
                            ".........\n" +
                            "FiNE I wIlL CHOosE a NuMbEr BetWEEN 1 AnD 20.");
                }
                giv = 0;
                int guess = input.nextInt();
                if (guess < num) {
                    System.out.println("YoUR GUEss IS ToO LOw.");
                } else if (guess > num) {
                    System.out.println("YOuR tOO HiGh.");
                } else {
                    System.out.println("I aM IMpResSED YOu HaVE GoTten The rIght AnSWeR. \n" +
                            "I GuESs EVen The MoST DimmISS AMoNg YoU HUmaNs cAN givE iNTElLegINt AnSwers SOMeTIMES.");
                    System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
                    won = true;
                    break;
                }
                if (count == 0 && !won) {
                    System.out.println("It WOuLd APPeAr YOu HAve LOst.");
                    System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
                    break;
                } else {
                    count--;
                }

            }

            //testing if they want to play again

            selection = input.nextInt();
            if (selection == 1) {
                System.out.println("YoU haVe MADE A WiSE CHoOse\n" +
                        "BEGIN REBOOT OF GENETIC LIFEFORM AND DISK OPERATING SYSTEM vERSION: 0.0.614723");
            }

        } while (selection == 1);


    }
}

