package baseball.controller;

import baseball.model.domain.GameMenu;
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
        boolean isContinue = true;
        outputView.printStartMessage();
        while (isContinue) {
            play();
            isContinue = restart();
        }

    }

    private void play() {
        boolean isFinish = true;
        while (isFinish) {
            String input = input();
        }
        finish();
    }

    private String input() {
        outputView.printNumberPrompt();
        return inputView.getNumber();
    }

    private boolean restart() {
        outputView.printRestartPrompt();
        String input = inputView.askRestart();
        return GameMenu.from(input);
    }

    private void finish() {
        outputView.printFinishMessage();
    }
}