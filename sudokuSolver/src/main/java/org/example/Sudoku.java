package org.example;

public class Sudoku {
    private Unit[][] grid;
    private int flag = -1;
    public Sudoku(Unit[][] grid){
        this.grid = grid;
    }
    public void solveSudoku(){
        solveHelperBacktracking(0, 0);
    }
    private void solveHelperBacktracking(int i, int j) {
        if (i == 9){
            flag = 0;
            return;
        }
        if (grid[i][j].getValue() != 0){
            if (j < 8){ solveHelperBacktracking(i, j + 1); }
            else { solveHelperBacktracking(i + 1, 0); }
        }
        else {
            for (int k = 1; k <= 9; k++){
                if (isValid(i, j, k)){
                    grid[i][j].setValue(k);

                    if (j < 8){ solveHelperBacktracking(i, j + 1); }
                    else { solveHelperBacktracking(i + 1, 0); }

                    if (flag == 0){ return; }
                    grid[i][j].setValue(0);
                }
            }
        }
    }
    public boolean isValid(int r, int c, int d){
        for(int i=0;i<9;i++)
        {
            if(grid[r][i].getValue()==d) return false;
            if(grid[i][c].getValue()==d) return false;
            if(grid[3*(r/3)+i/3][3*(c/3)+i%3].getValue()==d) return false;
        }
        return true;
    }
    public Unit[][] getGrid(){
        return grid;
    }
}
