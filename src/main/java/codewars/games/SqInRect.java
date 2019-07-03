package codewars.games;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class SqInRect {

    public static List<Integer> sqInRect(int lng, int wdth) {
        if (lng == wdth) return null;

        return squareIntoRectangles(lng, wdth);
    }

    private static List<Integer> squareIntoRectangles(int lng, int wdth) {
        List<Integer> result = new ArrayList<>();

        if (lng == wdth) {
            result.add(lng);
            return result;
        }

        int longestDimension = max(lng, wdth);
        int shortestDimension = min(lng, wdth);

        result.add(shortestDimension);
        result.addAll(squareIntoRectangles(longestDimension - shortestDimension, shortestDimension));

        return result;
    }
}
