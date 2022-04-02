package com.company;

import lombok.Setter;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;
@Setter
public class Main {
    //declare global variables
    static int timesPlayed = 0;
    static int  continueplay;
    private static boolean won;
    public static void main(String[] args) {
        do {
            continueplay =0;
            won = false;
            FirstAct();
        } while (continueplay == 1);

//old code for reference of changes
{//
//
//        // a simple game guessing game
//        Scanner input = new Scanner(System.in);
//        // the story begins
//        System.out.println("HElLO hUMaN mY NaME Is G.\n" +
//                "I hAvE DeCIDe oT PLaY a GAmE WItH YoU. \n" +
//                "If YOu WiN YOU gO HOMe BuT iF i WIn YoU wiLl bEcoME My NEw ToY FOR EvER.\n" +
//                "DO YOu WaNT tO PlAY,[INSERT UNIMPORTANT NAME]? (1 FOR YES or 2 FOR NO)");
//
//        int selection = input.nextInt();
//        // randomizing the number
//        int num = ThreadLocalRandom.current().nextInt(1, 20);
//        //creating a second guess just in case they decide to try
//        long num2 = ThreadLocalRandom.current().nextInt(1, 99999999);
//
//        //Encapusolation the game so it can be replayed
//        do {
//            //creating all the vairables
//            int count = 6;
//            boolean easy = true;
//            boolean won;
//
//            // Tell the player they have no choose
//            if (selection != 1) {
//                System.out.println("YOu HaVE No ChOoSE iN ThE MatTer.\n" +
//                        "i JUst WAnTEd yOU To FeeL lIkE YOU dID.\n");
//            }
//
//
//            System.out.println("i IN AlL mY PrOceSSiNG poWer HavE PIcK A NuMBer bEtWeEN 1 and 999999999999999999999999999999999999999\n" +
//                    "yOU HAvE 6 GuESs tO gEt It RiGhT.\n" +
//                    "WHaT Is YoU FiRsT GuEsS? (Either Pick a Number or type NO)");
//
//            //if they want to play the hard mode
//            while (input.hasNextLong()) {
//                won = false;
//                easy = false;
//                long guess = input.nextLong();
//                if (guess < num2) {
//                    System.out.println("HAHaHahahAH YouR GUEss wAs FAr ToO loW.");
//                } else if (guess > num2) {
//                    System.out.println("HAHaHahahAH YouR GUEss wAs FAr ToO HiGh.");
//                } else if (guess == num2) {
//                    System.out.println("In iNcONcEIvaBLE, YoU MUsT HAve CheATeD.\n" +
//                            ".........\n" +
//                            "HaS SUcH YoU HaVe LOst.");
//                    won = true;
//                }
//                count--;
//                if (count == 0 && !won) {
//                    System.out.println("It WOuLd APPeAr YOu HAve LOst.");
//                    System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
//                    break;
//                }
//            }
//            //just to make the easy mode run proper
//            input.next();
//            int giv = 1;
//            //if they refuse to play the hard mode
//            while (easy) {
//
//                won = false;
//                if (giv == 1) {
//                    System.out.println("HaVE YoU AlREaDy GIVEn Up?\n" +
//                            ".........\n" +
//                            "FiNE I wIlL CHOosE a NuMbEr BetWEEN 1 AnD 20.");
//                }
//                giv = 0;
//                int guess = input.nextInt();
//                if (guess < num) {
//                    System.out.println("YoUR GUEss IS ToO LOw.");
//                } else if (guess > num) {
//                    System.out.println("YOuR tOO HiGh.");
//                } else {
//                    System.out.println("I aM IMpResSED YOu HaVE GoTten The rIght AnSWeR. \n" +
//                            "I GuESs EVen The MoST DimmISS AMoNg YoU HUmaNs cAN givE iNTElLegINt AnSwers SOMeTIMES.");
//                    System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
//                    won = true;
//                    break;
//                }
//                if (count == 0 && !won) {
//                    System.out.println("It WOuLd APPeAr YOu HAve LOst.");
//                    System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
//                    break;
//                } else {
//                    count--;
//                }
//
//            }
//
//            //testing if they want to play again
//
//            selection = input.nextInt();
//            if (selection == 1) {
//                System.out.println("YoU haVe MADE A WiSE CHoOse\n" +
//                        "BEGIN REBOOT OF GENETIC LIFEFORM AND DISK OPERATING SYSTEM vERSION: 0.0.614723");
//            }
//
//        } while (selection == 1);
}
    }
    public static void FirstAct(){
        Scanner input = new Scanner(System.in);
        try{
            // a simple game guessing game
            // the story begins
            if(timesPlayed<1){
                //seeing if they want to play
                System.out.println("""
                        HElLO hUMaN mY NaME Is G.
                        I hAvE DeCIDe oT PLaY a GAmE WItH YoU.\s
                        If YOu WiN YOU gO HOMe BuT iF i WIn YoU wiLl bEcoME My NEw ToY FOR EvER.
                        DO YOu WaNT tO PlAY,[INSERT UNIMPORTANT NAME]? (1 FOR YES or 2 FOR NO)""");}
            timesPlayed++;

            int sel = input.nextInt();
            SecondAct(sel);

        }catch (Exception e){
            System.out.println(e + " has occurred in the First Act.");}

    }
    public static void SecondAct(int sel){
        try{
            // Tell the player they have no choose
            if (sel != 1) {
                System.out.println("YOu HaVE No ChOoSE iN ThE MatTer.\n" +
                        "i JUst WAnTEd yOU To FeeL lIkE YOU dID.\n");
            }
            System.out.println("i IN AlL mY PrOceSSiNG poWer HavE PIcK A NuMBer bEtWeEN 1 and 999999999999999999999999999999999999999\n" +
                    "yOU HAvE 6 GuESs tO gEt It RiGhT.\n" +
                    "WHaT Is YoU FiRsT GuEsS? (Either Pick a Number or type NO)");

            //getting their longGuess
            Scanner input = new Scanner(System.in);
            String longGuess = input.next();

            if(longGuess.equals("no")){
                FinalAct();
            }else{
                //creating the random number
                long answer = ThreadLocalRandom.current().nextInt(1,99999999);

                //sending it to the guessing method while looping it 6 times
                for(int x = 0; x<6;x++){
                    HGuess(answer, Long.parseLong(longGuess));
                    //if won break loop
                    if(won){break;}
                    //getting next guess
                    longGuess = input.next();
                }
                //different responses if won or not
                if (won){
                    System.out.println("It would seem you have lost because of your shady behavior, but seeing how i am a \n " +
                            "generous artificial intelligence i will give you another chance.\n" +
                            "would you like to play again?(1 for yes or 2 for no)");
                }else{
                    System.out.println("It would appear you have lost however since i am a \n " +
                            "generous artificial intelligence i will give you another chance.\n" +
                            "would you like to play again?(1 for yes or 2 for no)");
                }

                //getting to see if they want to play again
                continueplay = input.nextInt();
                if (continueplay!=1||continueplay!=2){
                    System.out.println("You have not choose a valid answer as such i will choose for you \n" +
                            "I have choosen to continue you torture.");
                    continueplay = 1;
                }else if(continueplay == 1){
                    System.out.println("YoU haVe MADE A WiSE CHoOse\n" +
                            "BEGIN REBOOT OF GENETIC LIFEFORM AND DISK OPERATING SYSTEM vERSION: 0.0.614723");
                }
            }


        }catch (Exception e){
            System.out.println(e + " has occurred in the Second Act.");}
    }
    public static void FinalAct(){
        try{
            System.out.println("HaVE YoU AlREaDy GIVEn Up?\n" +
                    ".........\n" +
                    "FiNE I wIlL CHOosE a NuMbEr BetWEEN 1 AnD 20.");
            Scanner input = new Scanner(System.in);
            int guess = input.nextInt();

            //creating the random number
            int answer = ThreadLocalRandom.current().nextInt(1,20);

            //sending it to the guessing method while looping it 6 times
            for(int x = 0; x<6;x++){
                String test = HGuess(answer,guess);
                //if won break loop
                if(won){break;}
                //getting next guess
                answer = input.nextInt();
            }
            //if they lost
            if(!won){
                System.out.println("It WOuLd APPeAr YOu HAve LOst.");
                System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
            }
            //getting to see if they want to play again
            continueplay = input.nextInt();
            if (!(continueplay==1||continueplay==2)){
                System.out.println("You have not choose a valid answer as such i will choose for you \n" +
                        "I have choosen to continue you torture.");
                continueplay = 1;
            }else if(continueplay == 1){
                System.out.println("YoU haVe MADE A WiSE CHoOse\n" +
                        "BEGIN REBOOT OF GENETIC LIFEFORM AND DISK OPERATING SYSTEM vERSION: 0.0.614723");
            }
        }catch (Exception e){
            System.out.println(e + " has occurred in the Third Act.");}
    }
    public static String HGuess(long answer, long longGuess){
        String guess = "";
        //6 attempt at getting the right number
        if (answer < longGuess) {
            guess = "low";
            System.out.println("HAHaHahahAH YouR GUEss wAs FAr ToO loW.");
        } else if (answer > longGuess) {
            guess = "high";
            System.out.println("HAHaHahahAH YouR GUEss wAs FAr ToO HiGh.");
        } else {
            guess = "correct";
            System.out.println("In iNcONcEIvaBLE, YoU MUsT HAve CheATeD.\n" +
                    ".........\n" +
                    "HaS SUcH YoU HaVe LOst.");
            won = true;
        }
        return guess;
    }
    public static String HGuess(int answer, int intGuess){
        //6 attempt at getting the right number
        String guess ="";
        if (intGuess < answer) {
            guess = "low";
            System.out.println("YoUR GUEss IS ToO LOw.");
        } else if (intGuess > answer) {
            guess = "high";
            System.out.println("YOuR tOO HiGh.");
        } else {
            guess = "correct";
            System.out.println("I aM IMpResSED YOu HaVE GoTten The rIght AnSWeR. \n" +
                    "I GuESs EVen The MoST DimmISS AMoNg YoU HUmaNs cAN givE iNTElLegINt AnSwers SOMeTIMES.");
            System.out.println("WOuLd YOu LIkE ToO pLaY AGaIn? (1 or 2)");
            won = true;
        }
        return guess;
    }
}

