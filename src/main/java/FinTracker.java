import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;

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

    //filtering all records based on price. Price < 0 means it is expense.
    //transform map to stream, using filter functionality and than transform back to map
    public Map<Integer,FinRecord>getExpenses() {
        return collectionOfRecords.entrySet()
                .stream()
                .filter(map -> map.getValue().getPrice() < 0) //filter by value
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));


    }

    //filtering all records based on price. Price > 0 means it is income.
    //transform map to stream, using filter functionality and than transform back to map
    public Map<Integer, FinRecord> getIncome() {
        return collectionOfRecords.entrySet()
                .stream()
                .filter(map -> map.getValue().getPrice() > 0) //filter by value
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

    }

    public Map<Integer,FinRecord> getAll() {
        return collectionOfRecords;

    }

    public int size() {
        return collectionOfRecords.size();
    }

}
