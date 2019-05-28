package Maze;

import javax.swing.*;
import java.awt.*;

public class Maze {
    public static void main(String[] args){
        new Maze();
    }

    public Maze() {

        JButton pause = new JButton();

        JFrame f = new JFrame();
        f.setTitle("Boulder Dash");
        f.add(new Board());
        f.setSize(407, 510);
        f.setLocationRelativeTo(null);
        f.getContentPane().setBackground(Color.BLACK);
        f.setResizable(false);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().add(new JButton("Pause"), BorderLayout.SOUTH);
        f.setVisible(true);
    }
}
