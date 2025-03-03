package org.example;

public class Cell {
    public boolean alive = false;
    private int x;
    private int y;
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }
    public void setAlive(boolean alive) {
        this.alive = alive;
    }
    public boolean isAlive(){
        return this.alive;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
