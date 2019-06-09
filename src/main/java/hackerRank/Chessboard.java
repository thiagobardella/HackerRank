package hackerRank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Chessboard {

    /*
    - n: an integer, the number of rows and columns in the board
    - k: an integer, the number of obstacles on the board
    - r_q: integer, the row number of the queen's position
    - c_q: integer, the column number of the queen's position
    */
//    static int queensAttack(int n, int k, int r_q, int c_q, int[][] obstacles) {
//        int attacksCounter = 0;
//
//        int rowTarget, colTarget = 0;
//
//        rowTarget = r_q;
//        colTarget = c_q+1;
//        for (int i = colTarget; i < n; i++) {
//
//        }
//
//
//        for (int i = 0; i < 8; i++) {
//
//
//        }
//
//
//    }

    public static int minimalNumberOfPackages(int items, int availableLargePackages, int availableSmallPackages) {
        int remainingItems, packagesUsed = 0;

        if (items < 5) {
            if (availableSmallPackages < items) return -1;
            else return items;
        }

        int largePackagesNecessary = items/5;
        if (largePackagesNecessary > availableLargePackages) {
            packagesUsed += availableLargePackages;
            remainingItems = items - availableLargePackages*5;
        }
        else  {
            packagesUsed += largePackagesNecessary;
            remainingItems = items%5;
        }

        if (availableSmallPackages < remainingItems) return -1;
        packagesUsed += remainingItems;
        return packagesUsed;
    }

    public static String transform(String input) {
        if (input.isEmpty()) return input;

        String[] characters = input.split("");
        String previousCharacter = "";

        List<String> result = new ArrayList<>();
        for (String character : characters) {
            if (!character.equals(previousCharacter)) result.add(character);
            previousCharacter = character;
        }

        return String.join("", result);
    }

    public static String transform2(String input) {
        if (input.isEmpty()) return input;

        String[] characters = input.split("");
        String previousCharacter = "";

        StringBuilder stringBuilder = new StringBuilder();

        for (String character : characters) {
            if (!character.equals(previousCharacter)) stringBuilder.append(character);
            previousCharacter = character;
        }

        return stringBuilder.toString();
    }

}
