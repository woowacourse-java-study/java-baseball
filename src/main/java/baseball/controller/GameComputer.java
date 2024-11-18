package baseball.controller;

import baseball.view.InputView;
import baseball.view.OutputView;

public class GameComputer {
    private final InputView inputView;
    private final OutputView outputView;

    public GameComputer(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        outputView.printStartMessage();
        while (true) {
            play();
        }
    }

    private void play() {
        while (true) {
            outputView.printNumberPrompt();
            inputView.getNumber();
        }
    }
}