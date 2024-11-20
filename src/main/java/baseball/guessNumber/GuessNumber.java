package baseball.guessNumber;

import baseball.game.controller.constant.Rules;

import java.util.ArrayList;
import java.util.List;

public class GuessNumber {
    public List<Integer> numbers;

    public GuessNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static GuessNumber from(List<Integer> numbers) {
        return new GuessNumber(numbers);
    }
}
