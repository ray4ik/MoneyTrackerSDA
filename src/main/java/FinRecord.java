public class FinRecord {

    /* This is the structure of the financial record
       which stores income / expense of particular thing.
       It stores information about name, price and month
       of income / expense */

    //name of the entry
    private String name;

    //price of the entry
    private Double price;

    //month of the entry
    private Integer month;

    public FinRecord(String name, Double price, Integer month) {
        this.name = name;
        this.price = price;
        this.month = month;
    }


    //setters and getters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }
}
