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

 class HQ {
    public static String HQ9(char code) {
        switch (code) {
            case 'H': {
                return "Hello World!";
            }
            case 'Q': {
                return "Q";
            }
            case '9': {
                StringBuilder stringBuilder = new StringBuilder();
                for(int i = 99; i >= 1; i--) {
                    if (i==1) {
                        stringBuilder.append(i).append(" bottle of beer on the wall, ").append(i).append(" bottle of beer.\n")
                                .append("Take one down and pass it around, no more bottles of beer on the wall.\n");
                    }
                    else {
                        stringBuilder.append(i).append(" bottles of beer on the wall, ").append(i).append(" bottles of beer.\n")
                                .append("Take one down and pass it around, ");
                                if (i==2) {
                                    stringBuilder.append("1 bottle of beer on the wall.\n");
                                }
                                else {
                                    stringBuilder.append(i - 1).append(" bottles of beer on the wall.\n");
                                }
                    }
                }
                stringBuilder.append("No more bottles of beer on the wall, no more bottles of beer.\n" +
                        "Go to the store and buy some more, 99 bottles of beer on the wall.");
                return stringBuilder.toString();
            }
            default: return null;
        }
    }
}
