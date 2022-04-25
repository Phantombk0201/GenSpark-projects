package com.company;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Locale;


public class Hangman extends JFrame implements ActionListener {
    Blank word;
    MyPanel panel;
    private int score =0;
    JTextField textFieldU;
    JTextField textFieldG;
    JButton buttonU;
    JButton buttonH;
    JButton buttonG;
    String username="Player1";
    private HashSet<Character> guesses = new HashSet<>();

    Hangman(){
        word = new Blank();

        panel = new MyPanel(word.getWrong(),word.getStrBlank(),"",score);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setUsernameBAT();
        setGuessBAT();
        setHighscoreBAT();

        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== buttonU){
            username=textFieldU.getText();
            System.out.println(username);
//            textField.setEditable(false);
            textFieldU.setEnabled(false);
            buttonU.setEnabled(false);
        }
        if(e.getSource()==buttonG){
            String message="";
            try{//if already guess
                if(guesses.contains(textFieldG.getText().toLowerCase(Locale.ROOT).charAt(0))){
                    message="YOU HAVE ALREADY GUESSED \"" +
                            textFieldG.getText().toUpperCase(Locale.ROOT).charAt(0)+"\"";
                }
                //if new guess
                else{
                    guesses.add(textFieldG.getText().toLowerCase(Locale.ROOT).charAt(0));
                    int aScore = word.contains(textFieldG.getText().toLowerCase(Locale.ROOT).charAt(0)).size();
                    score = score + aScore;
                }
            }catch (IndexOutOfBoundsException er){
                message = "YOU HAVE NOT MADE A GUESS";
            }

            textFieldG.setText("");
            this.remove(panel);
            this.repaint();
            panel = new MyPanel(word.getWrong(),word.getStrBlank(),message,score);
            this.add(panel);
            this.pack();

            //if lost
            if(word.getWrong()>5){
                new Highscore(score,username);
                int results = JOptionPane.showConfirmDialog(this,
                        "WOULD YOU LIKE TO PLAY AGAIN?",
                        "DO YOU WANT TO PLAY A GAME",JOptionPane.YES_NO_OPTION);
                if(results == 1 ){
                    System.exit(0);
                }else{
                    score = 0;
                    guesses.clear();
                    word = new Blank();
                }
            }
            //if won
            else if(!word.getStrBlank().contains("__")){
                int results = JOptionPane.showConfirmDialog(this,
                        "CONTINUE?",
                        "SMASH BRO'S ANNOUNCER",JOptionPane.YES_NO_OPTION);
                if(results == 1 ){
                    new Highscore(score,username);
                    System.exit(0);
                }else{
                    guesses.clear();
                    word = new Blank();

                    textFieldG.setText("");
                    this.remove(panel);
                    this.repaint();
                    panel = new MyPanel(word.getWrong(),word.getStrBlank(),message,score);
                    this.add(panel);
                    this.pack();
                }
            }

        }
        if(e.getSource()==buttonH){new ScoreBoard();}
    }

    public void setHighscoreBAT(){

        buttonH = new JButton("Highscore");
        buttonH.addActionListener(this);
        buttonH.setBounds(410,558,100,35);

        this.add(buttonH);
    }

    public void setUsernameBAT(){

        buttonU = new JButton("Submit");
        buttonU.addActionListener(this);
        buttonU.setBounds(90,8,80,35);

        textFieldU = new JTextField();
        textFieldU.setBounds(200,0,200,50);
        textFieldU.setFont(new Font("Consolas",Font.PLAIN,25));
        textFieldU.setForeground(new Color(0x00ff00));
        textFieldU.setBackground(Color.black);
        textFieldU.setCaretColor(Color.white);
        textFieldU.setText("USERNAME");

        this.add(buttonU);
        this.add(textFieldU);
    }

    public void setGuessBAT(){

        buttonG = new JButton("Submit");
        buttonG.addActionListener(this);
        buttonG.setBounds(100,558,80,35);

        textFieldG = new JTextField();
        textFieldG.setBounds(230,550,110,50);
        textFieldG.setFont(new Font("Consolas",Font.PLAIN,25));
        textFieldG.setForeground(Color.red);
        textFieldG.setBackground(Color.black);
        textFieldG.setCaretColor(Color.white);
        textFieldG.setText("GUESSES");

        this.add(buttonG);
        this.add(textFieldG);
    }
}
