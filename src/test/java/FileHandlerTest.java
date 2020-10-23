import org.junit.jupiter.api.Test;
import moneyTracker.*;

import static org.junit.jupiter.api.Assertions.*;

class FileHandlerTest {

    @Test
    void loadAndReadFromFile () throws Exception{
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 12., 10);
        ft.addEntry("tomato", 20., 10);

        FileHandler fh = new FileHandler("dataTest");
        fh.writeToFile(ft);

        FinTracker actual = fh.loadFromFile();
        assertEquals(2, actual.size());

        FinRecord frActual = actual.getEntry(1 );
        assertEquals("milk", frActual.getName());
        assertEquals(12.0, frActual.getPrice());
        assertEquals(10, frActual.getMonth());

        frActual = actual.getEntry(2);
        assertEquals("tomato", frActual.getName());
        assertEquals(20.0, frActual.getPrice());
        assertEquals(10, frActual.getMonth());

        ft.addEntry("banana", 15., 10);
        fh.writeToFile(ft);
        actual = fh.loadFromFile();
        assertEquals(3, actual.size());


    }

}