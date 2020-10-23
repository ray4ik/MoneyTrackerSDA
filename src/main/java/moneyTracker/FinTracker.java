package moneyTracker;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.io.Serializable;

public class FinTracker implements Serializable{

    //all entries that user input / edit during current run  stored in the map
    //key is id, which is generated here automatically, value - current financial record
    private final HashMap<Integer, FinRecord> collectionOfRecords;

    //identifier of the entry
    private int id;


    public FinTracker(){
        //id starts from 1 and will be incremented during adding new entry
        id = 1;
        collectionOfRecords = new HashMap<>();
    }

    public void addEntry(String name, Double price, Integer month)  {

        FinRecord addRecord = new FinRecord(name, price, month);
        //generation of id for the new entry and add them to the map
        collectionOfRecords.put(id++, addRecord);
    }

    public void updateEntry(Integer id, String name, Double price, Integer month) {

        //extracting entry by id
        FinRecord tmpRecord = collectionOfRecords.get(id);


        //if entry exits, need to update it
        if (tmpRecord != null) {
            System.out.println("Updating item with id " + id);
            System.out.println("Updating " + tmpRecord.toString());
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

    public int getTotalBalance() {
        int sum = 0;

        for (FinRecord value : collectionOfRecords.values()) {
            sum += value.getPrice();
        }

        return sum;
     }
 }

