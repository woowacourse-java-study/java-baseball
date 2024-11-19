package baseball.model;

import java.util.List;

public class Referee {

    public  Referee(Baseball computer, String userNumber) {
        List<Integer> computerNumbers = computer.getNumbers();
        int matchingCount =  countMatchingNumbers(computerNumbers, userNumber);
        int strikes = countSamePositionMatches(computerNumbers, userNumber);
        new Result(strikes, matchingCount-strikes);
    }

    private int countMatchingNumbers(List<Integer> computerNumbers, String userNumber) {
        int count = 0;
        for (char digitChar : userNumber.toCharArray()) {
            int currentDigit = Character.getNumericValue(digitChar);
            if (computerNumbers.contains(currentDigit)) {
                count++;
            }
        }
        return count;
    }
    public int countSamePositionMatches(List<Integer> computerNumbers, String userNumber) {
        int count = 0;
        int index = 0;
        for (int computerDigit : computerNumbers) {
            int userDigit = Character.getNumericValue(userNumber.charAt(index));
            if (computerDigit == userDigit) {
                count++;
            }
            index++;
        }
        return count;
    }
}
