package codewars.games;

import codewars.IntegerUtils;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SumParts {

    public static int[] sumParts(int[] ls) {
        List<Integer> list = IntegerUtils.intToIntegersList(ls);
        int[] result = new int[ls.length+1];

        List<Integer> res = IntStream.range(0,ls.length)
                .mapToObj(i -> list.subList(i, ls.length).stream().mapToInt(Integer::intValue).sum())
                .collect(Collectors.toList());

        IntStream.range(0, ls.length).forEach(i -> result[i] = res.get(i));

        return result;
    }
}
