package codewars.games;

import org.junit.Test;

import static org.junit.Assert.*;

public class BullsAndCowsTest {

    @Test
    public void shouldGenerateValidSecretNumber() {
        BullsAndCows bullsAndCows = new BullsAndCows(7536);

        assertEquals("1 bull and 0 cows", bullsAndCows.compareWith(1234));
        assertEquals("0 bulls and 2 cows", bullsAndCows.compareWith(5601));
        assertEquals("0 bulls and 3 cows", bullsAndCows.compareWith(6750));
        assertEquals("0 bulls and 4 cows", bullsAndCows.compareWith(6357));
        assertEquals("1 bull and 0 cows", bullsAndCows.compareWith(7014));
        assertEquals("1 bull and 1 cow", bullsAndCows.compareWith(6508));
        assertEquals("0 bulls and 0 cows", bullsAndCows.compareWith(4289));
        assertEquals("You win!", bullsAndCows.compareWith(7536));
    }

    @Test
    public void invalidTurnsShouldNotBeCounted() {
        BullsAndCows bac = new BullsAndCows(1234);
        for (int i = 0; i < 8; i++)
            try {
                bac.compareWith(11111);
                fail("The number sent to the compare with(11111) is invalid. You should throw IllegalArgumentException");
            } catch (IllegalArgumentException ignored) {}
        for (int i = 0; i < 8; i++) assertEquals("0 bulls and 0 cows", bac.compareWith(5678));
    }

    @Test
    public void outOfTurns() {
        BullsAndCows bac = new BullsAndCows(1234);
        for (int i = 0; i < 8; i++) assertEquals("1 bull and 1 cow", bac.compareWith(2035));
        for (int i = 0; i < 8; i++) assertEquals("Sorry, you're out of turns!", bac.compareWith(1234));
        try {
            assertEquals("Sorry, you're out of turns!", bac.compareWith(1111));
        } catch (IllegalArgumentException e) { fail("Expected: Sorry, you're out of turns!\nBut was catched IllegalArgumentException.\nYou should first check for amount of turns and not for the number validity.");}
    }

    @Test
    public void gameWon() {
        BullsAndCows bac = new BullsAndCows(1234);
        assertEquals("You win!", bac.compareWith(1234));
        assertEquals("You already won!", bac.compareWith(1234));
        for (int i = 0; i < 10; i++) assertEquals("You already won!", bac.compareWith(5678));
        try {
            assertEquals("You already won!", bac.compareWith(1111));
        } catch (IllegalArgumentException e) { fail("Expected: You already won!\nBut was catched IllegalArgumentException.\nYou should first check for winning the game and not for the number validity.");}
    }

    @Test
    public void invalidNumbers() {
        assertExceptions(10000);
        assertExceptions(999);
        assertExceptions(17245);
        assertExceptions(9855);
        assertExceptions(-190);
        assertExceptions(10585);
        assertExceptions(7);
    }

    private void assertExceptions(int n) {
        try {
            BullsAndCows bac = new BullsAndCows(n);
            fail("The number sent to the constructor is invalid. You should throw IllegalArgumentException");
        } catch (IllegalArgumentException ignored) {}

        try {
            new BullsAndCows(1234).compareWith(n);
            fail("The number sent to compareWith() is invalid. You should throw IllegalArgumentException");
        } catch (IllegalArgumentException ignored) {}
    }
}