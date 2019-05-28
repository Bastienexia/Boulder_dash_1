package Maze;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.*;

public class Map {

    private Scanner m;
    private String Map[] = new String[28];

    private Image dirt;
    private Image wall;
    private Image exit;
    private Image diamond;
    private Image rock;

    public Map() {

        ImageIcon img = new ImageIcon("C:/Users/Bastien/Documents/GitHub/Sprite/Sprite/Background.png");
        dirt = img.getImage();
        img = new ImageIcon("C:/Users/Bastien/Documents/GitHub/Sprite/Sprite/Blue_Wall.png");
        wall = img.getImage();
        img = new ImageIcon("C:/Users/Bastien/Documents/GitHub/Java_GameProject/images/sprites/exit.gif");
        exit = img.getImage();
        img = new ImageIcon("C:/Users/Bastien/Documents/GitHub/Java_GameProject/images/sprites/diamond.gif");
        diamond = img.getImage();
        img = new ImageIcon("C:/Users/Bastien/Documents/GitHub/Java_GameProject/images/sprites/rock.gif");
        rock = img.getImage();

        openFile();
        readFile();
        closeFile();
    }

    public Image getDirt(){
        return dirt;
    }

    public Image getWall(){
        return wall;
    }

    public Image getExit() {return exit;}

    public Image getDiamond() { return diamond; }

    public Image getRock() { return rock; }

    public String getMap(int x, int y){
        String index = Map[y].substring(x, x + 1);
        return index;
    }



    public void openFile(){

        try {
            m = new Scanner(new File("C:/Users/Bastien/Documents/GitHub/Java_GameProject/maps/Map1_2.txt"));
        }catch(Exception e){
            System.out.println("error loading map");
        }
    }

    public void readFile(){
        while(m.hasNext()){
            for(int i = 0; i < 28; i++){
                Map[i] = m.next();

            }
        }

    }

    public void closeFile(){
       m.close();

    }
}
