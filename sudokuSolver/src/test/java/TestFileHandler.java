import org.example.FileHandler;
import org.example.Unit;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestFileHandler {
    int TEST_GRID = 4;
    @Test
    public void testCreation(){
        FileHandler test = new FileHandler(1);
        assertNotNull(test);
    }
    @Test
    public void testFileHandlerParse(){
        FileHandler test = new FileHandler(TEST_GRID);
        Unit[][] grid = test.getGrid();
        for (int i = 0; i < 9; i++){
            for (int j = 0; j < 9; j++){
                Assertions.assertEquals(grid[i][j].getValue(), j);
            }
            }
    }
    @Test
    public void testFileHandlerOutputSolution(){
        FileHandler test = new FileHandler(TEST_GRID);
        test.createFile(test.getGrid());
    }
}

