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

                break;
                case 2:

                break;
                case 3:

                break;
                case 4:
                System.out.println("Closing up shop for the day!");
                quit = true;
                break;
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

    public static void listCatsForRent() {
        System.out.println("Cats for Rent");
    }

    // verifies that cat wanted exists
    public static boolean verifyCat(Cat catID) {
        return true;
    }

    // verifies taht the customer ID is real
    public static boolean verifyCustomerID(Customer customerID) {
        return true;
    }
}