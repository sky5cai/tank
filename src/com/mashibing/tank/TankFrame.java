package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    int x=200,y=200;
    public TankFrame() {

        setSize(800,600);
        setResizable(false);
        setVisible(true);
        setTitle("tank world9");
        this.addKeyListener(new MyKeyListener());
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
//        g.setColor(Color.BLACK);
        System.out.println("print");
        g.fillRect(x,y,90,90);
        x+=10;
        y+=10;
    }


    class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("key pressed");
            x+=20;
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }

}


