package com.mashibing.tank;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TankFrame extends Frame {

    Tank tank = new Tank(200,200,Dir.DOWN);

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
        tank.paint(g);
    }

    class MyKeyListener extends KeyAdapter{
        boolean bl=false;
        boolean bu=false;
        boolean br=false;
        boolean bd=false;

        @Override
        public void keyPressed(KeyEvent e) {
//            System.out.println("key pressed");
//            x+=20;
//            repaint();
            System.out.println("keyPressed");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl=true;
                    break;
                case KeyEvent.VK_UP:
                    bu=true;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("keyReleased");
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bl=false;
                    break;
                case KeyEvent.VK_UP:
                    bu=false;
                    break;
                case KeyEvent.VK_RIGHT:
                    br = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bd = false;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir(){
            if(!bl && !bu && !br && !bd) tank.setMoving(false);
            else{
                tank.setMoving(true);
                if(bl) tank.setDir(Dir.LEFT);
                if(bu) tank.setDir(Dir.UP);
                if(br) tank.setDir(Dir.RIGHT);
                if(bd) tank.setDir(Dir.DOWN);
            }
        }
    }
}


