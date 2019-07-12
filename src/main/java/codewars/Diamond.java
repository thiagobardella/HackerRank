package codewars;

import java.util.*;
import java.util.stream.IntStream;

public class Diamond {

    public static String print(int n) {
        if (n < 0 || n%2 == 0) return null;

        if (n == 1) return "*\n";

        List<String> sequence = new ArrayList<>();

        IntStream.range(0, n/2).forEach(line -> sequence.add(nCopiesOf(n/2 - line, " ") + nCopiesOf(1 + 2*line, "*")));

        List<String> sequenceMirrored = new ArrayList<>(sequence);
        Collections.reverse(sequenceMirrored);

        sequence.add(nCopiesOf(n, "*"));
        sequence.addAll(sequenceMirrored);
        return String.join("\n", sequence)+"\n";
    }

    public static String nCopiesOf(int n, String of) {
        return String.join("", Collections.nCopies(n, of));
    }

}
