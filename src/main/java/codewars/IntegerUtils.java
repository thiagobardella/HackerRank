package codewars;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.function.Function.identity;
import static java.util.stream.Collectors.*;

public class IntegerUtils {

    public static long countMax(List<String> upRight) {
        List<List<Long>> matrix = new ArrayList<>(new ArrayList<>());

        AtomicInteger highestValue = new AtomicInteger();
        upRight.forEach(command -> {
            int row = Integer.valueOf(command.split(" ")[0]);
            int col = Integer.valueOf(command.split(" ")[1]);


            IntStream.range(0, row).forEach( currentRow -> {
                List<Long> entireRow = currentRow < matrix.size() ? matrix.get(currentRow) : new ArrayList<>();
                IntStream.range(0, col).forEach( currentCol -> {
                    long previousValue = currentCol < entireRow.size() ? entireRow.get(currentCol) : 0;
                    if (currentCol <= entireRow.size())
                        entireRow.add(currentCol, previousValue+1);
                    else entireRow.set(currentCol, previousValue+1);

                });
                if (currentRow <= matrix.size())
                    matrix.add(currentRow, entireRow);
                else matrix.set(currentRow, entireRow);

            });
            highestValue.getAndIncrement();
        });

        long result =matrix.stream().map(row -> row.stream().filter(value -> value == highestValue.get()).count()).collect(Collectors.toList()).stream().mapToLong(l -> l).sum();
        return result;

    }


    public static int getNumberDisplayedNOddTimes(int[] input) {
        Map<Integer, Long> occurrences = Arrays.stream(input).boxed().collect(groupingBy(identity(), counting()));
        Optional<Integer> firstNumberDisplayedOddTimes = occurrences.keySet().stream().filter(key -> occurrences.get(key)%2 != 0).findFirst();
        return firstNumberDisplayedOddTimes.isPresent() ? firstNumberDisplayedOddTimes.get() : -1;
    }

    static String findNumber(List<Integer> arr, int k) {

        return arr.contains(k) ? "YES" : "NO";
    }

    public static int nthEven(int n) {
        return (n-1)*2;
    }

    static List<Integer> oddNumbers(int l, int r) {
        return IntStream.range(l, r+1).boxed().filter(number -> number%2 != 0).collect(Collectors.toList());

    }

    public static int priceCheck(List<String> products, List<Float> productPrices, List<String> productSold, List<Float> soldPrice) {
        AtomicInteger wrongPricesCounter = new AtomicInteger();

        IntStream.range(0, productSold.size()).forEach( idx -> {
            String product = productSold.get(idx);
            float price = productPrices.get(products.indexOf(product));
            if (soldPrice.get(idx) != price) wrongPricesCounter.getAndIncrement();
        });

        return wrongPricesCounter.get();
    }

    public static int sumOfMultiplesOf3or5(int input) {
        return IntStream.range(0, input).filter(number -> number%3 == 0 || number%5 == 0).sum();
    }


}
