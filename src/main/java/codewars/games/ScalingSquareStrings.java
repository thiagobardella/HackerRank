package codewars.games;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ScalingSquareStrings {
    public static String scale(String strng, int k, int v) {
        if (strng.isEmpty()) return strng;
        StringBuilder stringBuilder = new StringBuilder();

        strng.chars().mapToObj(c -> (char)c).forEach(c -> {
            if (c != '\n') {
                for (int i = 0; i < k; i++) {
                    stringBuilder.append(c);
                }
            }
            else stringBuilder.append("\n");
        });

        return Arrays.stream(stringBuilder.toString().split("\n"))
                .map(line -> String.join("\n", Collections.nCopies(v, line)))
                .collect(Collectors.joining("\n"));


//        List<String> lines = Arrays.asList(stringBuilder.toString().split("\n")) ;
//        List<String> scaledLines = new ArrayList<>();
//
//        lines.forEach(line -> {
//            for (int i = 0; i < v; i++) {
//                scaledLines.add(line);
//            }
//        });
//
//        return String.join("\n", scaledLines);
    }

}
