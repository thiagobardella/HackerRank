package codewars;

import java.util.ArrayList;
import java.util.List;

public class IntegerUtils {

    public static int nthEven(int n) {
        return (n-1)*2;
    }

    public static List<Integer> intToIntegersList(int[] input) {
        List<Integer> intList = new ArrayList<Integer>();
        for (int i : input)
        {
            intList.add(i);
        }
        return intList;
    }

}
