package codewars;

import java.util.*;

import java.util.stream.Collectors;

import static java.lang.Math.max;

public class StringUtils {

    public static String whoLikesIt(String... names) {
        StringBuilder result = new StringBuilder();

        if (names.length == 0) result.append("No one");
        else result.append(names[0]);

//        if (names.length <= 1) result.append("likes");
//        else {
//            if (names.length )
//        }

        result.append("this");
        return result.toString();
    }

    static String mergeStrings(String a, String b) {

//        if (b.length() > a.length()) return mergeStrings(b, a);

        StringBuilder result = new StringBuilder();

        String[] aChars = a.split("");
        String[] bChars = b.split("");

        int longestString = max(a.length(), b.length());

        for (int i = 0; i < longestString; i++) {
            if (i < aChars.length) result.append(aChars[i]);
            if (i < bChars.length) result.append(bChars[i]);
        }

//        Arrays.stream(a.split("")).forEach(character -> {
//            result.append(character);
//            if ()result.append()
//        });
        return result.toString();
    }

    // Complete the braces function below.
    static String[] braces(String[] values) {

        List<String> result = new ArrayList<>();

        Arrays.stream(values).forEach(value -> {
                    Stack<String> stackOfBraces = new Stack<>();
                    String[] bracesList = value.split("");
                    boolean isBalanced = true;
                    for (String brace : bracesList) {
                        if (brace.equals("(") || brace.equals("[") || brace.equals("{")) stackOfBraces.push(brace);
                        else if (brace.equals(")")) {
                            if (!stackOfBraces.peek().equals("(")) {
                                isBalanced = false;
                                break;
                            }
                            else stackOfBraces.pop();
                        }
                        else if (brace.equals("]")) {
                            if (!stackOfBraces.peek().equals("[")) {
                                isBalanced = false;
                                break;
                            }
                            else stackOfBraces.pop();
                        }
                        else if (brace.equals("}")) {
                            if (!stackOfBraces.peek().equals("{")) {
                                isBalanced = false;
                                break;
                            }
                            else stackOfBraces.pop();
                        }
                    }
                    result.add(isBalanced && stackOfBraces.isEmpty()? "YES" : "NO");
                }

        );

        String[] array = Arrays.copyOf(result.toArray(), result.size(),
                String[].class);
        return array;
    }


    static List<Integer> longestValidSubstringsLength(String[] input) {

        return Arrays.stream(input).map(sequence -> {
            Stack<String> stackOfParenthesis = new Stack<>();

            int longestLength = 0;
            int currentSubstringLength = 0;

            String[] parenthesisList = sequence.split("");
            for (String parenthesis : parenthesisList) {
                if (parenthesis.equals("(")) stackOfParenthesis.push(parenthesis);
                else if (stackOfParenthesis.isEmpty()) {
                    longestLength = max(longestLength, currentSubstringLength);
                    currentSubstringLength = 0;
                }
                else {
                    currentSubstringLength++;
                    currentSubstringLength++;
                    longestLength = max(longestLength, currentSubstringLength);
                    stackOfParenthesis.pop();
                }
            }

            return longestLength;
        }).collect(Collectors.toList());
    }

    public static List<String> usernamesSystem(List<String> u) {

        HashMap<String, Integer> users = new HashMap<>();
        HashMap<Integer, String> positions = new HashMap<>();

        for (int i = 0; i < u.size(); i++) {
            String originalUsername = u.get(i);
            String newUserName = originalUsername;
            while (true) {
                if (!users.containsKey(newUserName)) {
                    users.put(newUserName, 0);
                    positions.put(i, newUserName);
                    break;
                } else {
                    int counter = users.get(originalUsername);

                    users.remove(originalUsername);
                    users.put(originalUsername, ++counter);

                    newUserName = originalUsername + counter;
//
//                    users.put(username, 0);
//                    positions.put(i, username);
                }
            }
        }

        String[] results = new String[users.keySet().size()];
        positions.keySet().forEach(key -> results[key] = positions.get(key));

        return  Arrays.asList(results);

    }

}
