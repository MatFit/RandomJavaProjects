package org.example;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.util.concurrent.TimeUnit;
import java.util.Scanner;

// Things to do..
// One step feature
// A button that will keep the game of life going until
// the state remains the same
// add whatever is above in GUI

public class GameGridLayout {

    private static Grid grid = new Grid(40,40);
    final static int GRID_WIDTH = grid.getWidth();
    final static int GRID_HEIGHT = grid.getHeight();
    private JPanel gameContainer;
    private Timer timer;
    int iconSize = 10;

    JButton[][] buttonArray = new JButton[GRID_WIDTH][GRID_HEIGHT];
    ActionListener actionListener;
    JLabel output = new JLabel("Initalize cell board");

    public GameGridLayout() {
        JPanel gui = new JPanel(new BorderLayout(2,2));


        gui.setFocusable(true);
        gui.requestFocusInWindow();

        // Add key listener
        gui.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_2) {
                    // Map colors of button array to grid ->
                    grid.updateGrid();
                    changeAllButtonColor();
                }

                if (e.getKeyCode() == KeyEvent.VK_1) {
                    // While game state is still dynamic
                    // update Grid
                    // Change button colors
                    // Add sleep
                    while (!grid.getIsStatic()) {
                        System.out.println("asd");
                        grid.updateGrid();
                        changeAllButtonColor();

                        try {
                            TimeUnit.SECONDS.sleep(4);
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }

        });


        gui.setBorder(new EmptyBorder(4,4,4,4));
        gui.add(output,BorderLayout.PAGE_END);

        gameContainer = new JPanel(new GridLayout(GRID_WIDTH,GRID_HEIGHT,2,2));
        gui.add(gameContainer);


        actionListener = e -> {
            changeButtonColor((JButton)e.getSource());
            gui.requestFocusInWindow();
        };

        for (int i=0; i<GRID_WIDTH*GRID_HEIGHT; i++) {
            JButton b = getButton();
            gameContainer.add(b);
            buttonArray[i%GRID_WIDTH][i/GRID_HEIGHT] = b;
        }

        JFrame f = new JFrame("GameGridLayout");
        f.add(gui);
        f.pack();
        f.setMinimumSize(f.getSize());
        f.setLocationByPlatform(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
    }


    private void changeButtonColor(JButton button){
        for (int xx=0; xx<GRID_WIDTH; xx++) {
            for (int yy=0; yy<GRID_HEIGHT; yy++) {
                if (button.equals(buttonArray[xx][yy])) {
                    if (button.getBackground() == Color.WHITE){
                        button.setBackground(Color.RED);
                        grid.getCell(xx,yy).setAlive(true);
                    }
                    else {
                        button.setBackground(Color.WHITE);
                    }
                    break;
                }
            }
        }
    }
    private void changeAllButtonColor(){
        for (int xx=0; xx<GRID_WIDTH; xx++) {
            for (int yy=0; yy<GRID_HEIGHT; yy++) {
                JButton button = buttonArray[xx][yy];
                if (grid.getCell(xx,yy).isAlive()){
                    button.setBackground(Color.RED);
                }
                else {
                    button.setBackground(Color.WHITE);
                }
            }
        }
    }


    private JButton getButton() {
        JButton b = new JButton();

        b.setIcon(new ImageIcon(
                new BufferedImage(iconSize,iconSize,BufferedImage.TYPE_INT_ARGB)));

        b.setRolloverIcon(new ImageIcon(
                new BufferedImage(iconSize,iconSize,BufferedImage.TYPE_INT_RGB)));

        b.setMargin(new Insets(0,0,0,0));
        b.setBorderPainted(false);
        b.setContentAreaFilled(true);
        b.setBackground(Color.WHITE);
        b.addActionListener(actionListener);
        return b;
    }


    public static void main(String[] args) {
        Runnable r = () -> new GameGridLayout();
        SwingUtilities.invokeLater(r);
    }
}