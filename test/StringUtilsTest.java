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

}