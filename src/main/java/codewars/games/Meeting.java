package codewars.games;

import java.util.*;
import static java.util.stream.Collectors.*;

public class Meeting {

    //Best alternative
//    public static String meeting(String s) {
//        return Arrays.stream(s.toUpperCase().split(";"))
//                .map(guest -> guest.replaceAll("(\\w+):(\\w+)", "($2, $1)"))
//                .sorted()
//                .collect(Collectors.joining(""));
//    }

    public static String meeting(String s) {
        List<Friend> friends = parseFriends(s);

        Map<String, List<Friend>> groupedFriends = groupFriendsByLastName(friends);

        List<String> result = new ArrayList<>();

        groupedFriends.values()
                .stream()
                .flatMap(List::stream)
                .collect(toList())
                .forEach(friend -> result.add(friend.toString()));

        return String.join("", result);
    }

    private static TreeMap<String, List<Friend>> groupFriendsByLastName(List<Friend> friends) {
        return friends.stream()
                .collect(groupingBy(Friend::getLastName,
                                    TreeMap::new,
                                    collectingAndThen(toList(),
                                                        list -> {
                                                            list.sort(Comparator.comparing(Friend::getFirstName));
                                                            return list;
                                                        })));
    }

    public static List<Friend> parseFriends(String s) {
        return Arrays.stream(s.split(";")).map(Friend::parse).collect(toList());
    }
}

class Friend {

    private String firstName;
    private String lastName;

    public Friend(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static Friend parse(String input) {
        String[] fullName = input.split(":");
        return new Friend(fullName[0].toUpperCase(), fullName[1].toUpperCase());
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return "(" + lastName + ", " + firstName + ")";
    }

    @Override
    public boolean equals(Object obj) {
        Friend friend = (Friend)obj;

        return this.lastName.equals(friend.lastName) && this.firstName.equals(friend.firstName);
    }

    @Override
    public int hashCode() {
        return this.firstName.hashCode() + this.lastName.hashCode();
    }
}