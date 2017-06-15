import java.util.*;
import java.io.*;

public class RentACat {
    public static void main(String[] args) {
        // generates collection of cats and collection of customers
        ArrayList<Cat> cats = generateCats();
        ArrayList<Customer> customers = generateCustomers();

        // create scanner for user options
        Scanner inScan = new Scanner(System.in);
        boolean quit = false;
        while(!quit) {
            System.out.print("Option [1, 2, 3, 4] > ");

            int userOption = getUserOption(inScan);

            switch(userOption) {
                case 1:
                listCatsForRent(cats);
                break;
                case 2:
                String customerName = verifyCustomerID(customers, inScan);
                if (customerName.equals("Null")) {
                    System.out.println("That customer doesn't exist!");
                } else {
                    String catName = verifyAndRentCat(cats, inScan, customerName); 
                }
                break;
                case 3:
                returnCat(cats, inScan);
                break;
                case 4:
                System.out.println("Closing up shop for the day!");
                quit = true;
                break;
            }
        }
    }

    public static void returnCat(ArrayList<Cat> cats, Scanner s) {
        boolean returned = false;
        while(!returned) {
            System.out.print("Return which cat? > ");
            try {
                int catID = s.nextInt();
                s.nextLine();
                returned = verifyCat(cats, s);
            } catch (Exception e) {
                System.out.println("Invalid cat ID");
            }
        }
    }

    public static ArrayList<Cat> generateCats() {
        ArrayList<Cat> cats = new ArrayList<Cat>();

        Cat cat = new Cat(1, "Cool Cat", 1000.52);
        Cat otherCat = new Cat(2, "Fun Cat", 3002.10);
        Cat otherOtherCat = new Cat(3, "The Cat", 10000.43);

        cats.add(cat);
        cats.add(otherCat);
        cats.add(otherOtherCat);

        return cats;
    }

    public static ArrayList<Customer> generateCustomers() {
        ArrayList<Customer> customers = new ArrayList<Customer>();

        Customer customer = new Customer("I Want A Cool Cat", 301);
        Customer otherCustomer = new Customer("I Want A Fun Cat", 104);
        Customer otherOtherCustomer = new Customer("I Want The Cat", 1);

        customers.add(customer);
        customers.add(otherCustomer);
        customers.add(otherOtherCustomer);

        return customers;
    }

    public static int getUserOption(Scanner s) {
        int option = s.nextInt();  // user option
        s.nextLine(); // skip new line character
        return option;
    }

    public static void listCatsForRent(ArrayList<Cat> rentableCats) {
        System.out.println("Cats for Rent");
        
        // iterate through cats to see if they are rentable
        // print them out if they are
        for (Cat cat : rentableCats) {
            if (cat.rentable()) {
                System.out.println(cat.toString());
            }
        }
    }

    // verifies that cat wanted exists and then rents it
    public static String verifyAndRentCat(ArrayList<Cat> cats, Scanner s, String customer) {
        System.out.print("Cat ID > ");
        int catID = s.nextInt();
        s.nextLine();
        for (Cat cat : cats) {
            if (cat.getCatID() == catID) {
                cat.rentCat(customer);
                return cat.getCatName();
            }
        }
        System.out.println("Invalid cat ID");
        return "Null";
    }

    // verifies that cat wanted exists 
    public static boolean verifyCat(ArrayList<Cat> cats, Scanner s) {
        System.out.print("Cat ID > ");
        int catID = s.nextInt();
        s.nextLine();
        for (Cat cat : cats) {
            if (cat.getCatID() == catID) {
                return true;
            }
        }
        System.out.println("Invalid cat ID");
        return false;
    }

    // verifies taht the customer ID is real
    public static String verifyCustomerID(ArrayList<Customer> customers, Scanner s) {
        System.out.print("Customer ID > ");
        int customerID = s.nextInt();
        s.nextLine(); // remove new line character

        for (Customer customer : customers) {
            if (customerID == customer.getCustomerID()) {
                return customer.getCustomerName();
            }
        }
        return "Null";
    }
}