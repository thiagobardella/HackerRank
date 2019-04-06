import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringUtilsTest{

    @Test
    public void shouldValidateIsograms() {
        assertEquals(true, StringUtils.isIsogram("Dermatoglyphics"));
        assertEquals(true, StringUtils.isIsogram("isogram"));
        assertEquals(false, StringUtils.isIsogram("moose"));
        assertEquals(false, StringUtils.isIsogram("isIsogram"));
        assertEquals(false, StringUtils.isIsogram("aba"));
        assertEquals(false, StringUtils.isIsogram("moOse"));
        assertEquals(true, StringUtils.isIsogram("thumbscrewjapingly"));
        assertEquals(true, StringUtils.isIsogram(""));
    }

    @Test
    public void abcdeReturnsZero() {
        assertEquals(0, StringUtils.duplicateCount("abcde"));
    }

    @Test
    public void abcdeaReturnsOne() {
        assertEquals(1, StringUtils.duplicateCount("abcdea"));
    }

    @Test
    public void indivisibilityReturnsOne() {
        assertEquals(1, StringUtils.duplicateCount("indivisibility"));
    }

    @Test
    public void reallyLongStringContainingDuplicatesReturnsThree() {
        String testThousandA = new String(new char[1000]).replace('\0', 'a');
        String testHundredB = new String(new char[100]).replace('\0', 'b');
        String testTenC = new String(new char[10]).replace('\0', 'c');
        String test1CapitalA = new String(new char[1]).replace('\0', 'A');
        String test1d = new String(new char[1]).replace('\0', 'd');
        String test = test1d + test1CapitalA + testTenC +
                testHundredB + testThousandA;


        assertEquals(3, StringUtils.duplicateCount(test));
    }

    @Test
    public void digitalRoot() {
        assertEquals(2, StringUtils.digital_root(11));
    }


}