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
        int ball = checkBall(guessNumber);
        return GuessResult.from(strike, ball);
    }

    private int checkBall(GuessNumber guessNumber) {

    }

    private void checkStrike(GuessNumber guessNumber) {
    }
}
