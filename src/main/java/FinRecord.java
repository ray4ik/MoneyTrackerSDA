public class FinRecord {

    private String name;
    private Double price;
    private Integer month;

    public FinRecord(String name, Double price, Integer month) {
        this.name = name;
        this.price = price;
        this.month = month;
    }

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
