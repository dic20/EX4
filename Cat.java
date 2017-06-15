import java.text.*;

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

    // if the cat is rentable return true, else false
    public boolean rentable() {
        if (rentable) {
            return true;
        } else {
            return false;
        }
    }

    public void rentCat(String wantsToRent) {
        if (rentable) {
            rentable = false;
            customer = wantsToRent;
        } else {
            System.out.println("Sorry, " + name + " is not here!");
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

    public int getCatID() {
        return ID;
    }

    public String getCatName() {
        return name;
    }

    public String toString() {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        StringBuilder info = new StringBuilder();
        info.append("ID ");
        info.append(ID);
        info.append(". ");
        info.append(name);
        info.append(": ");
        info.append(formatter.format(costPerDay));
        info.append(" / day");
        return info.toString();
    }
}