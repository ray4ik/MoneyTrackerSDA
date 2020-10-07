import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class FinTracker {
    private final HashMap<Integer, FinRecord> collectionOfRecords;
    private int id;

    public FinTracker(){
        id = 1;
        collectionOfRecords = new HashMap<>();
    }

    public void addEntry(String name, Double price, Integer month)  {

        //generating id here
        FinRecord addRecord = new FinRecord(name, price, month);
        collectionOfRecords.put(id++, addRecord);
    }

    public void updateEntry(Integer id, String name, Double price, Integer month) {
        FinRecord tmpRecord = collectionOfRecords.get(id);
        if (tmpRecord != null) {
            if (name != null) {
                tmpRecord.setName(name);
            }
            if (price != null) {
                tmpRecord.setPrice(price);
            }
            if (month != null) {
                tmpRecord.setMonth(month);
            }
        }
    }

    public FinRecord getEntry(Integer id) {
        return collectionOfRecords.get(id);
    }

    public void removeEntry(Integer id) {
        collectionOfRecords.remove(id);
    }


    public ArrayList<FinRecord> getExpenses() {
        return null;

    }

    public ArrayList<FinRecord> getIncome() {
        return null;

    }

    public ArrayList<FinRecord> getAll() {
        return null;

    }

    public int size() {
        return collectionOfRecords.size();
    }

}
