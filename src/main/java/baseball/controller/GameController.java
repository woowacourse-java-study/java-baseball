package baseball.controller;

import baseball.model.domain.ComputerNumbers;
import baseball.model.domain.GameMenu;
import baseball.model.domain.PlayerNumbers;
import baseball.model.domain.Result;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        try {
            boolean isContinue = true;
            outputView.printStartMessage();
            while (isContinue) {
                play();
                isContinue = restart();
            }
        } catch (IllegalArgumentException e) {
//            outputView.printErrorMessage(e.getMessage());
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private void play() {
        boolean isFinish = false;
        ComputerNumbers computerNumbers = init();
        while (!isFinish) {
            PlayerNumbers playerNumbers =  input();
            isFinish = result(computerNumbers, playerNumbers);
        }
        finish();
    }

    private ComputerNumbers init() {
        return new ComputerNumbers();
    }

    private PlayerNumbers input() {
        outputView.printNumberPrompt();
        String input = inputView.getNumber();
        return new PlayerNumbers(input);
    }

    private boolean result(ComputerNumbers computerNumbers, PlayerNumbers playerNumbers) {
        Result result = computerNumbers.compare(playerNumbers);
        outputView.printResultMessage(result.toString());
        return result.isCorrect();
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