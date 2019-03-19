public class StringUtils {

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
