package TAKE;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class UtilsTest {

    @Test
    public void x() {
        String[] names1 = new String[] {"Ava", "Emma", "Olivia"};
        String[] names2 = new String[] {"Olivia", "Sophia", "Emma"};
        Utils.uniqueNames(names1, names2); // should print Ava, Emma, Olivia, Sophia

//        assertEquals();
    }

}