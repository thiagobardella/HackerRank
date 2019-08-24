package codewars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class IntegerUtilsTest extends IntegerUtils {

    @Test
    public void x() {
        String x = "2 3";
        List<String> list = new ArrayList<>();
        list.add(x);
        IntegerUtils.countMax(list);
    }

    @Test
    public void exampleTests() {
        assertEquals(0, IntegerUtils.nthEven(1));
        assertEquals(2, IntegerUtils.nthEven(2));
        assertEquals(4, IntegerUtils.nthEven(3));
        assertEquals(198, IntegerUtils.nthEven(100));
        assertEquals(2597466, IntegerUtils.nthEven(1298734));
    }

    @Test
    public void test() {
        assertEquals(23, IntegerUtils.sumOfMultiplesOf3or5(10));
    }

    @Test
    public void findTest() {
        assertEquals(5, IntegerUtils.getNumberDisplayedNOddTimes(new int[]{20,1,-1,2,-2,3,3,5,5,1,2,4,20,4,-1,-2,5}));
        assertEquals(-1, IntegerUtils.getNumberDisplayedNOddTimes(new int[]{1,1,2,-2,5,2,4,4,-1,-2,5}));
        assertEquals(5, IntegerUtils.getNumberDisplayedNOddTimes(new int[]{20,1,1,2,2,3,3,5,5,4,20,4,5}));
        assertEquals(10, IntegerUtils.getNumberDisplayedNOddTimes(new int[]{10}));
        assertEquals(10, IntegerUtils.getNumberDisplayedNOddTimes(new int[]{1,1,1,1,1,1,10,1,1,1,1}));
        assertEquals(1, IntegerUtils.getNumberDisplayedNOddTimes(new int[]{5,4,3,2,1,5,4,3,2,10,10}));
    }
}