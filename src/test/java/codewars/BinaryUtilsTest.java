package codewars;

import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryUtilsTest {

    @Test
    public void shouldConvertToBinary() {
        int zero = 0;
        int um = 1;

        int n1 = 2;
        int expected1 = 10;

        int n2 = 3;
        int expected2 = 11;

        assertEquals(zero, BinaryUtils.toBinary(zero));
        assertEquals(um, BinaryUtils.toBinary(um));
        assertEquals(expected1, BinaryUtils.toBinary(n1));
        assertEquals(expected2, BinaryUtils.toBinary(n2));
    }

}