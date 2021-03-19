/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication7;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.*;

class MyPanel extends JPanel{
    BufferedImage img = null;
    int img_x = 100, img_y = 100;
    
    
    public MyPanel(){
        
        try{
            img = ImageIO.read(new File("C:\\Users\\PC\\Documents\\c.jpg"));
        } catch (IOException e) {
            System.out.println(img);
            System.exit(1);
        }
        addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e) {
                int keycode = e.getKeyCode();
                switch (keycode) {
                    case KeyEvent.VK_UP:    
                        img_y -= 10;
                        break;
                    case KeyEvent.VK_DOWN:
                        img_y += 10;
                        break;
                    case KeyEvent.VK_LEFT:
                        img_x -= 10;
                        break;
                    case KeyEvent.VK_RIGHT:
                        img_x += 10;
                        break;
                }
                repaint();    
            }
            @Override
            public void keyReleased(KeyEvent arg0){ }
            @Override
            public void keyTyped(KeyEvent arg0) { }      
        });
            this.requestFocus();
            setFocusable(true);
    }
    @Override
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, img_x, img_y, null);
    }
}
    
public class JavaApplication7 extends JFrame{
    public JavaApplication7(){
        setSize(300,300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new MyPanel());
        setVisible(true);
    }
    
    
    public static void main(String [] args) {
        JavaApplication7 car = new JavaApplication7();
    }
}
