package com.company;

public class Hangman {
    public Hangman(int attempt){
        //Drawing each failed attempt at hangman
        switch (attempt) {
            case 0 -> System.out.println("""
                       +------+
                              |
                              |
                         =====|
                    """);
            case 1 -> System.out.println("""
                       +------+
                       O      |
                              |
                              |
                         =====|
                    """);
            case 2 -> System.out.println("""
                       +------+
                       O      |
                       |      |
                              |
                         =====|
                    """);
            case 3 -> System.out.println("""
                       +------+
                       O      |
                       |      |
                      /       |
                         =====|
                    """);
            case 4 -> System.out.println("""
                       +------+
                       O      |
                       |      |
                      / \\     |
                         =====|
                    """);
            case 5 -> System.out.println("""
                       +------+
                       O      |
                       |\\     |
                      / \\     |
                         =====|
                    """);
            case 6 -> {
                System.out.println("""
                           +------+
                           O      |
                          /|\\     |
                          / \\     |
                             =====|
                        """);
                System.out.println("Mission Failed, Better Luck Next Time!");
            }

        }

    }
}
