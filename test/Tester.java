import org.junit.Test;
import static org.junit.Assert.*;


public class Tester {

    // initially cat is rentable
    @Test
    public void testCatRentable() {
        Cat cat = new Cat(1, "a", 2.2);
	    assertTrue(cat.rentable());
    }

    // Cat should not be rentable after being rented
    @Test
    public void testCatRent() {
        Cat cat = new Cat(1, "a", 2.2);
        cat.rentCat("apple");
        assertFalse(cat.rentable());
    }

    // once cat is returned it should be rentable again
    @Test
    public void returnCatTest() {
        Cat cat = new Cat(1, "a", 2.2);
        cat.rentCat("apple");
        cat.returnCat();
        assertTrue(cat.rentable());
    }

    // system should not crash when you try to return cat that is not rented
    @Test
    public void returnCatRentable() {
        Cat cat = new Cat(1, "a", 2.2);
        cat.returnCat();
        cat.rentCat("apple");
        assertFalse(cat.rentable());
    }    
}