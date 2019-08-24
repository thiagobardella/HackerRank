package codewars;

import java.time.Duration;
import java.time.LocalTime;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.Arrays.stream;
import static java.util.stream.Collectors.*;

public class Escale {

    final static int  MONDAY = 0;
//    public int solution(int[] A) {
//
//        List<Integer> aAsList = Arrays.stream(A).boxed().collect(Collectors.toList());
//        if (aAsList.stream().anyMatch(number -> number == 0)) return 0;
//
//        return aAsList.stream().map(number -> number/Math.abs(number)).reduce(1, (a, b) -> a * b);
//
//    }

//    public int solution(int[] A) {
//
//        List<Integer> aAsList = Arrays.stream(A).boxed().sorted().collect(Collectors.toList());
//        Integer max = Collections.max(aAsList);
//        if (max < 0) return 1;
//        OptionalInt firstNotFound = IntStream.range(1, max).filter(number -> !aAsList.contains(number)).findFirst();
//        return firstNotFound.isPresent() ? firstNotFound.getAsInt() : max + 1;
//
//    }

    public  static int solution(String S) {

        List<Meeting> meetings = stream(S.split("\n")).map(Meeting::parse).collect(toList());

        Map<Integer, List<Long>> meetingsGroupedByDay = meetings.stream()
                .collect(groupingBy(Meeting::getDayOfTheWeek, TreeMap::new, collectingAndThen(toList(),
                        list -> {
                            LocalTime beginOfTheDay = LocalTime.MIN;
                            LocalTime endOfTheDay = LocalTime.MAX;


                            List<Long> freePeriods = new ArrayList<>();
                            Long beginOfTheDayFreeTime;
                            Long endOfTheDayFreeTime;
                            list.sort(Comparator.comparing(Meeting::getStart));

                            beginOfTheDayFreeTime = Duration.between(beginOfTheDay, list.get(0).getStart()).toMinutes();
                            endOfTheDayFreeTime = Duration.between(list.get(list.size()-1).getEnd(), endOfTheDay).toMinutes();

                            if (list.get(list.size()-1).getEnd() != LocalTime.MAX) endOfTheDayFreeTime++;

                            freePeriods.add(beginOfTheDayFreeTime);
                            freePeriods.add(endOfTheDayFreeTime);

                            return freePeriods;
                        })));

        List<Long> periodsSummed = new ArrayList<>();

        IntStream.range(0,7).forEach(day -> {
                    if (meetingsGroupedByDay.containsKey(day)) {
                        periodsSummed.add(meetingsGroupedByDay.get(day).get(0));
                        if (meetingsGroupedByDay.containsKey(day) && meetingsGroupedByDay.containsKey(day + 1)) {
                            periodsSummed.add(meetingsGroupedByDay.get(day).get(1) + meetingsGroupedByDay.get(day + 1).get(0));
                        }

                        periodsSummed.add(meetingsGroupedByDay.get(day).get(1));
                    }
                }
        );

        return Math.toIntExact(Collections.max(periodsSummed));

    }

}


class Meeting {

    private int dayOfTheWeek;
    private LocalTime start;
    private LocalTime end;

    private Meeting(int dayOfTheWeek, LocalTime start, LocalTime end) {
        this.dayOfTheWeek = dayOfTheWeek;
        this.start = start;
        this.end = end;
    }

    public static Meeting parse(String line) {
        try {
            String[] dayPeriod = line.split(" ");
            String dayOfTheWeekString = dayPeriod[0];
            String periodStr = dayPeriod[1];
            String startStr = periodStr.split("-")[0];
            String endStr = periodStr.split("-")[1];

            int dayOfTheWeek;
            switch (dayOfTheWeekString) {
                case "Mon":
                    dayOfTheWeek = 0;
                    break;
                case "Tue":
                    dayOfTheWeek = 1;
                    break;
                case "Wed":
                    dayOfTheWeek = 2;
                    break;
                case "Thu":
                    dayOfTheWeek = 3;
                    break;
                case "Fri":
                    dayOfTheWeek = 4;
                    break;
                case "Sat":
                    dayOfTheWeek = 5;
                    break;
                default:
                    dayOfTheWeek = 6;

            }

            LocalTime start = Integer.valueOf(startStr.split(":")[0]) != 24 ?
                    LocalTime.of(Integer.valueOf(startStr.split(":")[0]), Integer.valueOf(startStr.split(":")[1])) :
                    LocalTime.MAX;

            LocalTime end = Integer.valueOf(endStr.split(":")[0]) != 24 ?
                    LocalTime.of(Integer.valueOf(endStr.split(":")[0]), Integer.valueOf(endStr.split(":")[1])) :
                    LocalTime.MAX;

            return new Meeting(dayOfTheWeek, start, end);
        } catch (Exception ex) {
            return null;
        }
    }

    public int getDayOfTheWeek() {
        return dayOfTheWeek;
    }

    public LocalTime getStart() {
        return start;
    }

    public LocalTime getEnd() {
        return end;
    }
}