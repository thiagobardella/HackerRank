package codewars;

import java.util.Stack;

public class BinaryUtils {

    public static int toBinary(int n) {
        if (n == 0 || n==1) return n;

        StringBuilder stringBuilder = new StringBuilder();
        while (n/2 != 1) {
            stringBuilder.append(n%2);
            n/=2;
        }
        stringBuilder.append(n%2).append(n/2);
        return Integer.parseInt(stringBuilder.reverse().toString());
    }

    public static int toBinaryOptimal(int n) {

        String binaryString = Integer.toBinaryString(n);
        return Integer.parseUnsignedInt(binaryString);
    }
}
