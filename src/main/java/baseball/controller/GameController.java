package baseball.controller;

import baseball.dto.ComputerDto;
import baseball.dto.MatchDto;
import baseball.model.NumberParser;
import baseball.model.NumberRandomGenerator;
import baseball.model.Numbers;
import baseball.model.Referee;
import baseball.model.RetryValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameController {
    private final String RESTART = "1";
    private final String END = "2";
    private final InputView inputView;
    private final OutputView outputView;
    private final NumberRandomGenerator numberRandomGenerator;
    private final NumberParser numberParser;
    private final Referee referee;
    private final RetryValidator retryValidator;

    public GameController(InputView inputView, OutputView outputView, NumberRandomGenerator numberRandomGenerator,
                          NumberParser numberParser, Referee referee, RetryValidator retryValidator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.numberRandomGenerator = numberRandomGenerator;
        this.numberParser = numberParser;
        this.referee = referee;
        this.retryValidator = retryValidator;
    }

    public void run() {
        intro();
        do {
            ComputerDto computerDto = new ComputerDto(numberRandomGenerator.generate());
            gameLoop(computerDto);
        } while (restartGame());
    }

    private void gameLoop(ComputerDto computerDto) {
        while (true) {
            outputView.responseGameNumbers();
            String inputString = inputView.requestGameNumbers();
            Numbers playerNumbers = numberParser.parse(inputString);
            MatchDto matchDto = playerNumbers.match(computerDto.getNumbers());
            outputView.responseMatchResult(matchDto);
            if (referee.win(matchDto)) {
                outputView.responseGameOver();
                break;
            }
        }
    }

    private void intro() {
        outputView.responseGameIntro();
    }

    private boolean restartGame() {
        outputView.responseGameRetry();
        String inputRetryString = inputView.requestGameRetry();
        retryValidator.validateInputRetry(inputRetryString);
        return inputRetryString.trim().equals(RESTART);
    }
}
