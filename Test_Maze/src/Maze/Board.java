package Maze;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Board extends JPanel implements ActionListener {

    private Timer timer;

    private Map m;
    private Player p;

    public int diamondcounter;

    public Board(){

        m = new Map();
        p = new Player();
        addKeyListener(new Al());
        setFocusable(true);

        timer = new Timer(25, this);
        timer.start();
    }



    public void actionPerformed(ActionEvent e){

        if(m.getMap(p.getTileX(), p.getTileY()).equals("V")){
            diamondcounter = diamondcounter + 1;
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }

        if(m.getMap(p.getTileX(), p.getTileY()).equals("E")){
            if(diamondcounter >= 3) {
                JFrame w = new JFrame();
                JOptionPane.showMessageDialog(w, "You Won !", "Result", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        }
        repaint();
    }

    public void paint(Graphics g) {
        super.paint(g);

        for(int y = 0; y < 28; y++){
            for(int x = 0; x < 25; x++){
                if(m.getMap(x, y).equals("D")){
                    g.drawImage(m.getDirt(), x * 16, y * 16, null);
                }
                if(m.getMap(x, y).equals("X")){
                    g.drawImage(m.getWall(), x * 16, y * 16, null);
                }
                if(m.getMap(x, y).equals("E")){
                    g.drawImage(m.getExit(), x * 16, y * 16, null);
                }
                if(m.getMap(x, y).equals("V")){
                    g.drawImage(m.getDiamond(), x * 16, y * 16, null);
                }
                if(m.getMap(x, y).equals("R")){
                    g.drawImage(m.getRock(), x * 16, y * 16, null);
                }
                

            }
        }



        g.drawImage(p.getPlayer(), p.getTileX() * 16, p.getTileY() * 16, null);

    }


    public class Al extends KeyAdapter{

        public void keyPressed(KeyEvent e){
            int keycode = e.getKeyCode();

            if (keycode == KeyEvent.VK_UP){
                if(!m.getMap(p.getTileX(), p.getTileY() - 1).equals("X")) {
                    if(!m.getMap(p.getTileX(), p.getTileY() - 1).equals("R")) {
                        p.move(0, -1);
                    }
                }
            }

            if (keycode == KeyEvent.VK_DOWN){
                if(!m.getMap(p.getTileX(), p.getTileY() + 1).equals("X")) {
                    if(!m.getMap(p.getTileX(), p.getTileY() + 1).equals("R")) {
                        p.move(0, 1);
                    }
                }
            }

            if (keycode == KeyEvent.VK_LEFT){
                if(!m.getMap(p.getTileX() - 1, p.getTileY()).equals("X")) {
                    if(!m.getMap(p.getTileX() - 1, p.getTileY()).equals("R")) {
                        p.move(-1, 0);
                    }
                }
            }

            if (keycode == KeyEvent.VK_RIGHT){
                if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("X")) {
                    if(!m.getMap(p.getTileX() + 1, p.getTileY()).equals("R")) {
                        p.move(1, 0);
                    }
                }
            }
        }

        public void keyRelased(KeyEvent e){

        }

        public void keyTyped(KeyEvent e){

        }
    }

}
