package baseball.config;

import baseball.controller.BaseballController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Appconfig {
    public BaseballController baseballController() {
        return new BaseballController(inputView(), outputView());
    }

    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

}
