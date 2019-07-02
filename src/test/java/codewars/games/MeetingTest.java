package codewars.games;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class MeetingTest {

    @Test
    public void shouldParseFriends() {
        String friendsText = "Fred:Corwill;Wilfred:Corwill";

        List<Friend> expectedFriends = new ArrayList<>();
        expectedFriends.add(new Friend("FRED", "CORWILL"));
        expectedFriends.add(new Friend("WILFRED", "CORWILL"));

        List<Friend> friends = Meeting.parseFriends(friendsText);
        assertEquals(expectedFriends.get(0), friends.get(0));
        assertEquals(expectedFriends.get(1), friends.get(1));
    }

    private static void testing(String s, String exp) {
        System.out.println("Testing:\n" + s);
        String ans = Meeting.meeting(s);
        System.out.println("Actual: " + ans);
        System.out.println("Expect: " + exp);
        System.out.println(ans.equals(exp));
        assertEquals(exp, ans);
    }
    @Test
    public void test() {
        testing("Alexis:Wahl;John:Bell;Victoria:Schwarz;Abba:Dorny;Grace:Meta;Ann:Arno;Madison:STAN;Alex:Cornwell;Lewis:Kern;Megan:Stan;Alex:Korn",
                "(ARNO, ANN)(BELL, JOHN)(CORNWELL, ALEX)(DORNY, ABBA)(KERN, LEWIS)(KORN, ALEX)(META, GRACE)(SCHWARZ, VICTORIA)(STAN, MADISON)(STAN, MEGAN)(WAHL, ALEXIS)");
        testing("John:Gates;Michael:Wahl;Megan:Bell;Paul:Dorries;James:Dorny;Lewis:Steve;Alex:Meta;Elizabeth:Russel;Anna:Korn;Ann:Kern;Amber:Cornwell",
                "(BELL, MEGAN)(CORNWELL, AMBER)(DORNY, JAMES)(DORRIES, PAUL)(GATES, JOHN)(KERN, ANN)(KORN, ANNA)(META, ALEX)(RUSSEL, ELIZABETH)(STEVE, LEWIS)(WAHL, MICHAEL)");
        testing("Alex:Arno;Alissa:Cornwell;Sarah:Bell;Andrew:Dorries;Ann:Kern;Haley:Arno;Paul:Dorny;Madison:Kern",
                "(ARNO, ALEX)(ARNO, HALEY)(BELL, SARAH)(CORNWELL, ALISSA)(DORNY, PAUL)(DORRIES, ANDREW)(KERN, ANN)(KERN, MADISON)");

    }
}