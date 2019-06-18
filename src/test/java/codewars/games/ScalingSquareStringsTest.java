package codewars.games;

import org.junit.Test;

import static org.junit.Assert.*;

public class ScalingSquareStringsTest{

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test() {
        System.out.println("Fixed Tests scale");
        String a ="abcd\nefgh\nijkl\nmnop";
        String r = "aabbccdd\naabbccdd\naabbccdd\neeffgghh\neeffgghh\neeffgghh\niijjkkll\n"
                + "iijjkkll\niijjkkll\nmmnnoopp\nmmnnoopp\nmmnnoopp";
        testing(ScalingSquareStrings.scale(a, 2, 3), r);
        testing(ScalingSquareStrings.scale("", 5, 5), "");
        testing(ScalingSquareStrings.scale("Kj\nSH", 1, 2),"Kj\nKj\nSH\nSH");
    }
}