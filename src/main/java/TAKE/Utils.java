package TAKE;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Utils {

    public static boolean isPalindrome(String word) {
        word = word.toLowerCase();

        StringBuilder stringBuilder = new StringBuilder(word);

        return stringBuilder.reverse().toString().equals(word);
    }
    public static String[] uniqueNames(String[] names1, String[] names2) {
        List<String> namesList = Arrays.asList(names1);
        namesList.addAll(Arrays.asList(names2));

        return (String[]) namesList.stream().distinct().toArray();
    }

    // Generic function to concatenate multiple lists in Java
    public static<T> List<T> concatenate(List<T>... lists)
    {
        return Stream.of(lists)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
    }






}
