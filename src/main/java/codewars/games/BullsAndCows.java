package codewars.games;

import java.util.stream.Collectors;

public class BullsAndCows {
    private int secretNumber;
    private int remainingTrials;
    private boolean alreadyWinner;

    public BullsAndCows(int n) {
        validateNumber(n);
        this.secretNumber = n;
        this.remainingTrials = 8;
        this.alreadyWinner = false;
    }

    public String compareWith(int n) {
        if (isAlreadyWinner()) return "You already won!";
        if (getRemainingTrials() == 0) return "Sorry, you're out of turns!";
        validateNumber(n);

        int bulls, cows = 0;

        String secretNumberStr = String.valueOf(secretNumber);
        String guessNumberStr = String.valueOf(n);

        bulls = (int) secretNumberStr.chars().mapToObj(i -> (char) i)
                .filter(c -> secretNumberStr.indexOf(c) == guessNumberStr.indexOf(c)).count();

        if (bulls == 4) {
            setAlreadyWinner(true);
            return "You win!";
        }

        cows = (int) guessNumberStr.chars().mapToObj(i -> (char) i)
                .filter(c -> secretNumberStr.contains(String.valueOf(c)) &&
                        (secretNumberStr.indexOf(c) != guessNumberStr.indexOf(c))).count();

        String bullPrint = bulls != 1 ? "bulls" : "bull";
        String cowPrint = cows != 1 ? "cows" : "cow";

        fail();
        return bulls + " " + bullPrint + " and " + cows + " " + cowPrint;
    }

    private static int generateSecretNumber(int digits) {
        StringBuilder stringBuilder = new StringBuilder();
        int randomDigit;
        for (int i = 0; i < digits; i++) {
            do {
                randomDigit = (int)(Math.random()*10+1);
            }while (stringBuilder.indexOf(String.valueOf(randomDigit)) != -1);
            stringBuilder.append(randomDigit);
        }
        return Integer.parseInt(stringBuilder.toString());
    }

    private static int generateSecretNumber2(int digits) {
        int randomNumber;
        do {
            randomNumber = (int)(Math.random()*10000+1000);
        }while (String.valueOf(randomNumber).chars().distinct().count() != String.valueOf(digits).chars().count());

        return randomNumber;
    }

    private void validateNumber(int n) {
        if (n < 0 || String.valueOf(n).chars().count() != 4 || String.valueOf(n).chars().distinct().count() != 4)
            throw new IllegalArgumentException();
    }

    public void fail() {
        this.remainingTrials--;
    }

    public int getRemainingTrials() {
        return remainingTrials;
    }

    public boolean isAlreadyWinner() {
        return alreadyWinner;
    }

    public void setAlreadyWinner(boolean alreadyWinner) {
        this.alreadyWinner = alreadyWinner;
    }
}