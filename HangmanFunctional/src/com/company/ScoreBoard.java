package com.company;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ScoreBoard extends JFrame implements ActionListener {

    ScorePanel panel;
    JTextField textField;
    JButton button;

    ScoreBoard(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        panel = new ScorePanel();

        setHighscoreBAT();

        this.add(panel);

        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== button){
            this.dispose();
        }
    }
    public void setHighscoreBAT(){

        button = new JButton("Exit");
        button.addActionListener(this);
        button.setBounds(170,300,100,35);

        this.add(button);
    }
}
