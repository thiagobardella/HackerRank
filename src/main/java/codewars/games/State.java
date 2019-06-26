package codewars.games;

import java.util.*;
import static java.util.stream.Collectors.*;
import static java.util.stream.Collectors.groupingBy;

public class State {

    public static String byState(String str) {
        List<String> result = new ArrayList<>();
        List<String> lines = Arrays.asList(str.split("\n"));

        List<FriendToVisit> friendsToVisit = lines.stream().map(FriendToVisit::new).collect(toList());

        Map<String, List<String>> friendsByState =
                friendsToVisit.stream().collect(groupingBy(FriendToVisit::getState, mapping(FriendToVisit::text, toList())));

        //Alternative
//        Map<String, List<Person>> groupedPeople =
//                Arrays.stream(friends)
//                        .filter(s -> !s.isEmpty())
//                        .map(Person::parse)
//                        .collect(groupingBy(Person::getState,
//                                TreeMap::new,
//                                collectingAndThen(toList(),
//                                        list -> {
//                                            list.sort(Comparator.comparing(Person::getName));
//                                            return list;
//                                        })));
//
//
        Object[] states = friendsByState.keySet().toArray();
        Arrays.sort(states);
        for (int i = 0; i < states.length; i++) {
            Object state = states[i];
            if (i == 0) result.add(state.toString());
            else result.add(" " + state.toString());
            List<String> friends = friendsByState.get(state);
            Collections.sort(friends);
            result.addAll(friends);
        }

        return String.join("\n",result);
    }
}

class KnownStates {

    public HashMap<String, String> initials = new HashMap<String, String>();

    //Alternative
//    private static Map<String, String> codeToStateName =
//            Map.of(
//                    "AZ", "Arizona",
//                    "CA", "California",
//                    "ID", "Idaho",
//                    "IN", "Indiana",
//                    "MA", "Massachusetts",
//                    "OK", "Oklahoma",
//                    "PA", "Pennsylvania",
//                    "VA", "Virginia");

    public KnownStates() {
        initials.put("AZ", "Arizona");
        initials.put("CA", "California");
        initials.put("ID", "Idaho");
        initials.put("IN", "Indiana");
        initials.put("MA", "Massachusetts");
        initials.put("OK", "Oklahoma");
        initials.put("PA", "Pennsylvania");
        initials.put("VA", "Virginia");
    }



    public HashMap<String, String> getInitials() {
        return initials;
    }
}

class FriendToVisit {

    private String name;
    private String address;
    private String city;
    private String state;

    public FriendToVisit(String input) {
        KnownStates knownStates = new KnownStates();
        try {
            String[] components = input.split(",");
            this.name = components[0].trim();
            this.address = components[1].trim();
            this.city = components[2].substring(0, components[2].length() - 2).trim();
            String stateInitials = components[2].substring(components[2].length() - 2);
            this.state = knownStates.getInitials().get(stateInitials).trim();
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }


    public String getState() {
        return state;
    }

    public String text() {
        return "..... " + this.name + " " + this.address + " " + this.city + " " + this.state;
    }
}