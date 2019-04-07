package codewars.chessboard;

import org.apache.commons.math3.fraction.BigFraction;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Player {

    public static String game(long n) {
        // TODO (The problem here is that the code take too long to process all the sums)
        List<List<BigFraction>> chessboard = new ArrayList<>();
        initialize(chessboard, n);
        BigFraction sum = sumElements(chessboard);

        if (sum.getDenominator().equals(BigInteger.ONE)) {
            return "[" + sum.getNumerator().toString() + "]";
        }
        else
            return "[" + sum.getNumerator().toString() + ", " + sum.getDenominator().toString() + "]";
    }

    private static void initialize(List<List<BigFraction>> chessboard, long n) {
        for (long i = 1; i <= n; i++) {
            List<BigFraction> row = new ArrayList<>();
            for (long j = 1; j <= n; j++) {
                long denominator = i+j;
                row.add(new BigFraction(j, denominator));
            }
            chessboard.add(row);
        }
    }

    private static BigFraction sumElements(List<List<BigFraction>> chessboard) {
        BigFraction result = new BigFraction(0);
        for (List<BigFraction> row : chessboard) {
            for (BigFraction element : row ) {
                result = result.add(element);
            }
        }
        return result;
    }
}
