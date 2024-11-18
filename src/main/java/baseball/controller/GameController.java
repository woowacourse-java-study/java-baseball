package baseball.controller;

import baseball.model.domain.ComputerNumbers;
import baseball.model.domain.GameMenu;
import baseball.model.domain.GameNumbers;
import baseball.model.domain.PlayerNumbers;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;
    private final GameNumbers gameNumbers;

    public GameController(InputView inputView, OutputView outputView, GameNumbers gameNumbers) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.gameNumbers = gameNumbers;
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
        boolean isFinish = false;
        ComputerNumbers computerNumbers = new ComputerNumbers();
        while (!isFinish) {
            PlayerNumbers playerNumbers = new PlayerNumbers(input());
            String result = gameNumbers.calculateResult(computerNumbers, playerNumbers);
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