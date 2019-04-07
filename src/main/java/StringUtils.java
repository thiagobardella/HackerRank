import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

public class StringUtils {

    public static int duplicateCount(String text) {
        List<Character> textCharacters = new ArrayList<>();
        String textLowCase = text.toLowerCase();
        for (char c : textLowCase.toCharArray()) {
           textCharacters.add(c);
        }
        textCharacters.removeIf(c -> (textLowCase.lastIndexOf(c) == textLowCase.indexOf(c)));
        return Math.toIntExact(textCharacters.stream().distinct().count());
    }

    private static Map<Character, Long> charFrequenciesMap(final String text) {
        return text.codePoints()
        .map(Character::toLowerCase)
        .mapToObj(c -> (char) c)
        .collect(groupingBy(identity(), counting()));
    }

    static int duplicateCountOptimal(final String text) {
        return (int) charFrequenciesMap(text).values().stream()
        .filter(i -> i > 1)
        .count();
    }
    //My Answer
    public static boolean isIsogram(String input) {
        input = input.toLowerCase();
        char[] characters = input.toCharArray();
        for (char character : characters) {
            String remainingString = input.replaceFirst(String.valueOf(character), "");
            if (remainingString.contains(String.valueOf(character))) return false;
            input = remainingString;
        }
        return true;
    }

    //Best answer
    public static boolean  isIsogramOptimal(String str) {
        return str.length() == str.toLowerCase().chars().distinct().count();
    }
}
