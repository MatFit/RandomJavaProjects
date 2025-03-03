package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandler {
    private Scanner myReader;
    private File myObj;
    private Unit[][] grid = new Unit[9][9];

    public FileHandler(Integer choice) {
        parseFile(choice);
    }

    public void parseFile(Integer choice) {
        try {
            int r = 0;
            myObj = choiceGrid(choice);
            myReader = new Scanner(myObj);


            while (myReader.hasNextLine()) {
                String line = myReader.nextLine();
                String[] values = line.split(",");
                for (int c = 0; c < 9; c++) {
                    grid[r][c] = new Unit(Integer.parseInt(values[c]), r, c);
                }
                r++;
            }

            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public File choiceGrid(Integer choice) {
        {
            switch (choice) {
                case 1:
                    return new File("..\\src\\test\\resources\\grid\\Grid1");
                case 2:
                    return new File("..\\src\\test\\resources\\grid\\Grid2");
                case 3:
                    return new File("..\\src\\test\\resources\\grid\\Grid3");
                case 4:
                    return new File("..\\src\\test\\resources\\grid\\TestGrid1");
                default:
                    throw new IllegalArgumentException("Unexpected value: " + choice);
            }
        }

    }
    public void createFile(Unit[][] grid) {
        try {
            System.out.println("Writing to file...");
            String filePath = "..\\src\\main\\java\\Solutions\\solution.txt";
            File file = new File(filePath);
            FileWriter fileWriter = new FileWriter(file);
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (j == 8) {
                        fileWriter.write(grid[i][j].getValue() + "\n");
                    }
                    else{
                        fileWriter.write(grid[i][j].getValue() + ",");
                    }
                }
            }
            fileWriter.close();

        } catch (Exception e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public Unit[][] getGrid() {
        return grid;
    }
}
