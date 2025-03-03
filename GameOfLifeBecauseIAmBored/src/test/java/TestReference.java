import org.example.Cell;
import org.junit.jupiter.api.Test;

public class TestReference {
    @Test
    public void testingStuff(){
        Cell cell = new Cell(0,0);
        assert cell.isAlive();

    }
}
