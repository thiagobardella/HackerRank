package codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class IntegerUtilsTest extends IntegerUtils {

    @Test
    public void exampleTests() {
        assertEquals(0, IntegerUtils.nthEven(1));
        assertEquals(2, IntegerUtils.nthEven(2));
        assertEquals(4, IntegerUtils.nthEven(3));
        assertEquals(198, IntegerUtils.nthEven(100));
        assertEquals(2597466, IntegerUtils.nthEven(1298734));
    }
}