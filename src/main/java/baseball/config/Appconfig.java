package baseball.config;

import baseball.controller.BaseballController;
import baseball.generator.BaseballNumberGenerator;
import baseball.generator.BaseballNumberGeneratorImpl;
import baseball.validation.InputValidation;
import baseball.validation.InputValidationImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Appconfig {
    public BaseballController baseballController() {
        return new BaseballController(inputView(), outputView(), inputValidation(),baseballNumberGenerator());
    }

    public InputValidation inputValidation(){
        return new InputValidationImpl();
    }

    public BaseballNumberGenerator baseballNumberGenerator(){
        return new BaseballNumberGeneratorImpl();
    }
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

}
