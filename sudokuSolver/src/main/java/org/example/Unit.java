package org.example;

public class Unit {
    int value = 0;
    int row = 0;
    int column = 0;
    int group = 0;

    public Unit(int value, int row, int column) {
        this.value = value;
        this.row = row;
        this.column = column;
        this.group = (row / 3) * 3 + (column / 3);

    }
    public int getValue() {
        return value;
    }
    public int getRow() {
        return row;
    }
    public int getColumn() {
        return column;
    }
    public int getGroup() {
        return group;
    }
    public void setValue(int value) {
        this.value = value;
    }
}
