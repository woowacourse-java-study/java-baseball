package baseball.config;

import baseball.controller.GameController;
import baseball.model.NumberParser;
import baseball.model.NumberRandomGenerator;
import baseball.model.Referee;
import baseball.model.RetryValidator;
import baseball.view.InputView;
import baseball.view.OutputView;

public class AppConfig {
    public GameController gameController() {
        return new GameController(inputView(), outputView(), numberRandomGenerator(), numberParser(), referee(),
                retryValidator());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

    public NumberRandomGenerator numberRandomGenerator() {
        return new NumberRandomGenerator();
    }

    public NumberParser numberParser() {
        return new NumberParser();
    }

    public Referee referee() {
        return new Referee();
    }

    public RetryValidator retryValidator() {
        return new RetryValidator();
    }
}
