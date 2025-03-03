import org.example.Unit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TestUnit {
    @Test
    public void testCreation() {
        Unit testUnit = new Unit(1, 0, 0);
        assertNotNull(testUnit);
    }
    @Test
    public void testValueRowCol() {
        Unit testUnit = new Unit(1, 2, 3);
        Assertions.assertEquals(testUnit.getValue(), 1);
        Assertions.assertEquals(testUnit.getRow(), 2);
        Assertions.assertEquals(testUnit.getColumn(), 3);
    }
    @Test
    public void testGroup() {
        Unit testUnit = new Unit(1, 6, 7);
        int getConfidentGroup = calculateGroup(6,7);
        Assertions.assertEquals(testUnit.getGroup(), getConfidentGroup);
    }
    public int calculateGroup(int row, int column) {
        int box = 0;
        if (row < 3) {
            if (column < 3) {
                box = 0;
            } else if (column < 6) {
                box = 1;
            } else {
                box = 2;
            }
        } else if (row < 6) {
            if (column < 3) {
                box = 3;
            } else if (column < 6) {
                box = 4;
            } else {
                box = 5;
            }
        } else {
            if (column < 3) {
                box = 6;
            } else if (column < 6) {
                box = 7;
            } else {
                box = 8;
            }
        }
        return box;
    }

}

