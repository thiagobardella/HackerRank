package codewars.games;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class SqInRectTest {

    @Test
    public void test1() {
        List<Integer> res = new ArrayList<Integer>(Arrays.asList(3, 2, 1, 1));
        for (int r : res)
            assertEquals(res, SqInRect.sqInRect(5, 3));
    }

    @Test
    public void test2() {
        assertEquals(null, SqInRect.sqInRect(5, 5));
    }

}