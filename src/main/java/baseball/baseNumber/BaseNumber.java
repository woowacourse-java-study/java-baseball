package baseball.baseNumber;

import baseball.game.controller.constant.Rules;
import baseball.guessNumber.GuessNumber;
import baseball.guessResult.GuessResult;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseNumber {
    private final List<Integer> numbers;

    public BaseNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static BaseNumber create() {
        Set<Integer> distinctNumbers = new HashSet<>();
        while(distinctNumbers.size() < Rules.BASE_NUMBER_COUNT) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!distinctNumbers.contains(randomNumber)) {
                distinctNumbers.add(randomNumber);
            }
        }
        return new BaseNumber(distinctNumbers.stream().toList());
    }

    public GuessResult match(GuessNumber guessNumber) {
        int strike = checkStrike(guessNumber);
        int temporaryBall = checkTemporaryBall(guessNumber);
        return GuessResult.from(strike, temporaryBall - strike);
    }

    private int checkStrike(GuessNumber guessNumber) {
        int strike = 0;
        for (int i = 0; i < Rules.BASE_NUMBER_COUNT; ++i) {
            int singleGuessNumber = guessNumber.numbers.get(i);
            if (isStrike(singleGuessNumber, numbers.get(i))) {
                strike++;
            }
        }
        return strike;
    }

    private int checkTemporaryBall(GuessNumber guessNumber) {
        int ball = 0;
        for (int i = 0; i < Rules.BASE_NUMBER_COUNT; ++i) {
            if (isBall(guessNumber.numbers.get(i))) {
                ball++;
            }
        }
        return ball;
    }

    private boolean isStrike(int guessNumber, int baseNumber) {
        return guessNumber == baseNumber;
    }

    private boolean isBall(int singleGuessNumber) {
        return numbers.contains(singleGuessNumber);
    }
}
