package codewars;

import java.util.Arrays;
import java.util.OptionalInt;

public class FindOutlier{

    static int find(int[] integers){
        if (isAnOddSequence(integers))
            return getFirstEvenNumber(integers);
        return getFirstOddNumber(integers);
    }

    public static boolean isAnOddSequence(int[] integers) {
        int oddCounter = 0;
        int evenCounter = 0;

        for (int i = 0; i < 3; i++) {
            if(integers[i]%2 != 0) oddCounter++;
            else evenCounter++;
        }
        return oddCounter > evenCounter;
    }

    public static int getFirstOddNumber(int[] integers) {
        OptionalInt firstOddNumber = Arrays.stream(integers).filter(number -> number%2 != 0).findFirst();
        return firstOddNumber.isPresent() ? firstOddNumber.getAsInt() : null;
    }

    public static int getFirstEvenNumber(int[] integers) {
        OptionalInt firstEvenNumber = Arrays.stream(integers).filter(number -> number%2 == 0).findFirst();
        return firstEvenNumber.isPresent() ? firstEvenNumber.getAsInt() : null;
    }
}