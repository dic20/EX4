public class Customer {
    private String name;
    private int ID;
    public Customer(String n, int i) {
        name = n;
        ID = i;
    }

    public String getCustomerName() {
        return name;
    }

    public int getCustomerID() {
        return ID;
    }
}