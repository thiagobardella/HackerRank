package codewars;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static org.junit.Assert.*;

public class StringUtilsTest {


    @Test
    public void shou() {
        String a = "ab";
        String b = "zsd";
        StringUtils.mergeStrings(a,b);
    }

    @Test
    public void braces() {
        String[] test = new String[2];
        test[0] = "()";
//        test[1] = "([])";
        test[1] = "([)]";

        StringUtils.braces(test);
    }

    @Test
    public void shouldGetValidSubstringLengthOfParenthesis() {
        String[] test = new String[7];
        test[0] = "()";
        test[1] = "(((((((";
        test[2] = "((((((()";
        test[3] = "(()(";
        test[4] = "()()((";
        test[5] = "((()()())))";
        test[6] = "()(())(";

        List<Integer> expected = new ArrayList<>();
        expected.add(2);
        expected.add(0);
        expected.add(2);
        expected.add(2);
        expected.add(4);
        expected.add(10);
        expected.add(6);
//
//        int[] expected = new int[test.length];
//        expected[0] = 2;
//        expected[1] = 0;
//        expected[2] = 2;
//        expected[3] = 2;
//        expected[4] = 4;
//        expected[5] = 10;
//        expected[6] = 6;

        List<Integer> result = StringUtils.longestValidSubstringsLength(test);

        IntStream.range(0, expected.size()).forEach(index -> assertEquals(expected.get(index), result.get(index)));

    }

    @Test
    public void s() {
        List<String> u = new ArrayList<>();
        u.add("alex");
        u.add("alex");
        u.add("xylo");
        u.add("alex");
        u.add("alex");
        u.add("alex");
        u.add("xylo");

        List<String> expected = new ArrayList<>();
        expected.add("alex");
        expected.add("alex1");
        expected.add("xylo");
        expected.add("alex2");
        expected.add("alex3");
        expected.add("alex4");
        expected.add("xylo1");


        List<String> result = StringUtils.usernamesSystem(u);
        IntStream.range(0, expected.size()).forEach(index -> assertEquals(expected.get(index), result.get(index)));
    }
}