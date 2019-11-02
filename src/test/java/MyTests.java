import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class MyTests {
    @Test // JUnit test
    void testSomething () { // test name
        Integer c = new Integer (3) ; // Prefix values
        assertEquals (7 , c ) ; // Expected results
    }
}
