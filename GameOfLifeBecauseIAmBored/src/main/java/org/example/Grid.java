package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Grid {
    private int width;
    private int height;
    private Cell[][] grid;
    private Cell[][] pastGrid;
    boolean isStatic = false;
    public Grid(int width, int height){
        this.width = width;
        this.height = height;
        this.grid = new Cell[width][height];
        populateGrid();
    }
    public void populateGrid(){
        for (int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                this.grid[i][j] = new Cell(i,j);
            }
        }
    }
    public boolean isEmpty(){
        for (int i = 0; i < width; i++){
            for(int j = 0; j < height; j++){
                if (this.grid[i][j].isAlive()){
                    return false;
                }
            }
        }
        return true;
    }

    public int getNumberofAlive(Cell cell){
        int aliveNeighbors = 0;
        int cellX = cell.getX();
        int cellY = cell.getY();

        for (int x = cellX - 1; x <= cellX + 1; x++) {
            for (int y = cellY - 1; y <= cellY + 1; y++) {
                if (x < width && x >= 0 && y < width && y >= 0) {
                    if (this.grid[x][y].isAlive() && !(x == cellX && y == cellY)) {
                        aliveNeighbors++;
                    }
                }
            }
        }
        return aliveNeighbors;
    }
    public void updateGrid() {
        if (pastGrid == grid){
            this.isStatic = true;
            return;
        }

        Cell[][] newGrid = new Cell[width][height];
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < height; j++) {
                int neighbors = getNumberofAlive(grid[i][j]);
                if (grid[i][j].isAlive()) {
                    newGrid[i][j] = new Cell(i,j);
                    newGrid[i][j].setAlive(neighbors == 2 || neighbors == 3);
                } else {
                    newGrid[i][j] = new Cell(i,j);
                    newGrid[i][j].setAlive(neighbors == 3 || neighbors == 6);
                }
            }
        }
        pastGrid = grid;
        grid = newGrid;
    }
    public int getHeight() {
        return height;
    }
    public int getWidth() {
        return width;
    }
    public Cell getCell(int x, int y){
        return grid[x][y];
    }
    public boolean getIsStatic(){
        return isStatic;
    }
}
