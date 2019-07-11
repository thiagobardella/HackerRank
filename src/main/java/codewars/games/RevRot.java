package codewars.games;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RevRot {

    public static String revRot(String strng, int sz) {

        if (sz <= 0 || strng.isEmpty() || sz > strng.length()) return "";

        List<String> strngAsList = Arrays.asList(strng.split(""));

        return IntStream.range(0, strng.length()/sz)
                 .mapToObj(start -> {
                     int fromIndex = start * sz;
                     int toIndex = fromIndex + sz;
                     return strngAsList.subList(fromIndex, toIndex);
                 })
                 .map(chunk -> {
                     if (sumDigitsCubes(chunk)%2 == 0) {
                         StringBuilder stringBuilder = new StringBuilder();
                         stringBuilder.append(String.join("", chunk)).reverse();
                         return stringBuilder.toString();
                     }
                     return rotateLeft(1, chunk);
                 })
                 .collect(Collectors.joining());
    }

    public static int sumDigitsCubes(List<String> input) {
        return input.stream().mapToInt(digit -> (int)Math.pow(Integer.valueOf(digit), 3)).sum();
    }

    public static String rotateLeft(int offset, List<String> input) {
        String inputString = String.join("", input);
        int i = offset % inputString.length();
        return inputString.substring(i) + inputString.substring(0, i);

    }
}