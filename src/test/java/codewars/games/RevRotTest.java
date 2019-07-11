package codewars.games;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class RevRotTest {

    private static void testing(String actual, String expected) {
        assertEquals(expected, actual);
    }

    @Test
    public void test1() {
        System.out.println("Fixed Tests: revRot");
        testing(RevRot.revRot("1234", 0), "");
        testing(RevRot.revRot("", 0), "");
        testing(RevRot.revRot("1234", 5), "");
        String s = "733049910872815764";
        testing(RevRot.revRot(s, 5), "330479108928157");
        testing(RevRot.revRot("123456987654", 6), "234561876549");
        testing(RevRot.revRot("123456987653", 6), "234561356789");
        testing(RevRot.revRot("66443875", 4), "44668753");
        testing(RevRot.revRot("66443875", 8), "64438756");
        testing(RevRot.revRot("664438769", 8),"67834466");
        testing(RevRot.revRot("123456779", 8), "23456771");
//        revrot("", 8) --> ""
//        revrot("123456779", 0) --> ""
        testing(RevRot.revRot("563000655734469485", 4), "0365065073456944");


    }

    @Test
    public void testCubeFunction() {
        List<String> input = Arrays.asList("123".split(""));
        assertEquals(RevRot.sumDigitsCubes(input), 36);
    }
}