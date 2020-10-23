import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import moneyTracker.*;

public class FinRecordTest {

    @Test
    public void testTestGetName() {
        FinRecord testRecord = new FinRecord("apple", 20., 10);
        assertEquals("apple", testRecord.getName());
    }

}