package baseball.game.controller;

import baseball.baseNumber.BaseNumber;
import baseball.game.controller.constant.InputMessage;
import baseball.game.controller.constant.OutputMessage;
import baseball.game.controller.constant.Rules;
import baseball.guessNumber.GuessNumber;
import baseball.guessResult.GuessResult;
import baseball.view.Inputview;
import baseball.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final OutputView outputView;
    private final Inputview inputview;

    public GameController(OutputView outputView, Inputview inputview) {
        this.outputView = outputView;
        this.inputview = inputview;
    }

    public void play () {
        do {
            playSingle();
        } while(UserWantsToPlayMore());
    }

    private void playSingle() {
        outputView.print(OutputMessage.GAME_START);
        BaseNumber number = BaseNumber.create();
        GuessResult guessResult = null;
        do {
            String input = inputview.promptUserInput(InputMessage.GUESS_BASE_NUMBER);
            List<Integer> inputNumbers = validateGuessNumber(input);
            GuessNumber guessNumber = GuessNumber.from(inputNumbers);
            guessResult = number.match(guessNumber);
            outputView.print(guessResult);
        } while(!guessResult.fullStrike());

    }

    private List<Integer> validateGuessNumber(String input) {
        List<Integer> numbers = new ArrayList<>();
        validateLength(input);
        addNumbers(numbers, input);
        return numbers;
    }

    private void addNumbers(List<Integer> numbers, String input) {
        for (int i = 0; i < Rules.BASE_NUMBER_COUNT; ++i) {
            try {
                int number = Integer.parseInt(input.substring(i, i+1));
                numbers.add(number);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateLength(String input) {
        if (input.length() != 3) {
            throw new IllegalArgumentException();
        }
    }

    private boolean UserWantsToPlayMore() {
        return false;
    }

}
