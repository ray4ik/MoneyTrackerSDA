import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class FinTrackerTest {

    @Test
    void addEntry() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        assertEquals(1, ft.size());
    }

    @Test
    void addEntryTwo() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        ft.addEntry("banana", 20.0, 9);
        assertEquals(2, ft.size());
    }

    @Test
    void updateEntry() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        ft.updateEntry(1,"banana", 20.0, 9);
        FinRecord actualRecord = ft.getEntry(1);

        assertEquals( "banana", actualRecord.getName());
        assertEquals( 20, actualRecord.getPrice());
        assertEquals( 9, actualRecord.getMonth());
    }

    @Test
    void getEntry() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        FinRecord actualRecord = ft.getEntry(1);

        assertEquals( "milk", actualRecord.getName());
        assertEquals( 5.0, actualRecord.getPrice());
        assertEquals( 10, actualRecord.getMonth());

    }

    @Test
    void getNonexistentEntry() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        FinRecord actualRecord = ft.getEntry(2);

        assertNull(actualRecord);

    }

    @Test
    void updateNonexistentEntry() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        ft.updateEntry(2,"banana", 20.0, 9);
        FinRecord actualRecord = ft.getEntry(1);

        assertEquals( "milk", actualRecord.getName());
        assertEquals( 5.0, actualRecord.getPrice());
        assertEquals( 10, actualRecord.getMonth());
    }

    @Test
    void updateEntryWoChanges() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        ft.updateEntry(1, null, null, null);

        FinRecord actualRecord = ft.getEntry(1);

        assertEquals( "milk", actualRecord.getName());
        assertEquals( 5., actualRecord.getPrice());
        assertEquals( 10, actualRecord.getMonth());
    }

    @Test
    void removeEntry() {

        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        ft.addEntry("banana", 20.0, 9);
        ft.addEntry("cookie", 10.0, 8);

        assertEquals(3, ft.size());
        ft.removeEntry(2);
        assertEquals(2, ft.size());


        FinRecord actualRecord = ft.getEntry(3);
        assertEquals( "cookie", actualRecord.getName());
        assertEquals( 10., actualRecord.getPrice());
        assertEquals( 8, actualRecord.getMonth());

        actualRecord = ft.getEntry(1);
        assertEquals( "milk", actualRecord.getName());
        assertEquals( 5., actualRecord.getPrice());
        assertEquals( 10, actualRecord.getMonth());
    }

    @Test
    void getExpenses() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", -5.0, 10);
        ft.addEntry("banana", -20.0, 9);
        ft.addEntry("cookie", -10.0, 8);
        ft.addEntry("salary", 20000.0, 9);
        ft.addEntry("dividend", 20000.0, 8);

        Map <Integer, FinRecord> actual =  ft.getExpenses();

        assertEquals(3, actual.size());
        assertEquals(-5.0, actual.get(1).getPrice());
        assertEquals(10, actual.get(1).getMonth());
        assertEquals("milk", actual.get(1).getName());
    }

    @Test
    void getIncome() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", -5.0, 10);
        ft.addEntry("banana", -20.0, 9);
        ft.addEntry("cookie", -10.0, 8);
        ft.addEntry("salary", 20000.0, 9);
        ft.addEntry("dividend", 20000.0, 8);

        Map <Integer, FinRecord> actual =  ft.getIncome();

        assertEquals(2, actual.size());

        assertEquals(20000., actual.get(4).getPrice());
        assertEquals(9, actual.get(4).getMonth());
        assertEquals("salary", actual.get(4).getName());
    }

    @Test
    void getAll() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", -5.0, 10);
        ft.addEntry("banana", -20.0, 9);
        //ft.addEntry("cookie", -10.0, 8);
        ft.addEntry("salary", 20000.0, 9);
        ft.addEntry("dividend", 20000.0, 8);

        ft.getAll();
        assertEquals(4, ft.size());
    }

    @Test
    void size() {
        FinTracker ft = new FinTracker();
        ft.addEntry("milk", 5.0, 10);
        ft.addEntry("banana", 20.0, 9);
        ft.addEntry("cookie", 10.0, 8);

        assertEquals(3, ft.size());
    }
}