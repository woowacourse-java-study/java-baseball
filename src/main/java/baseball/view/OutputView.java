package baseball.view;

import baseball.guessResult.GuessResult;

public class OutputView {

    public void print(String message) {
        writeLine(message);
    }

    private void writeLine(String message) {
        System.out.println(message);
    }

    public void print(GuessResult guessResult) {
        System.out.println(guessResult);
    }
}
