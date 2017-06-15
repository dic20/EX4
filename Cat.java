public class Cat {
    private int ID;
    private String name;
    private double costPerDay;
    private boolean rentable;
    private String customer;
    public Cat(int i, String n, double c) {
        ID = i;
        name = n;
        costPerDay = c;
        rentable = true;    // all cats can be rented at first
        customer = "";
    }

    public void rentCat(String wantsToRent) {
        if (rentable) {
            rentable = false;
            customer = wantsToRent;
        } else {
            System.out.println(name + "has been rented to " + customer);
        }
    }

    // return cat
    public void returnCat() {
        if (!rentable) {
            rentable = true;
            customer = "";
        } else {
            System.out.println("That cat was not rented to you...awk");
        }
    }
}