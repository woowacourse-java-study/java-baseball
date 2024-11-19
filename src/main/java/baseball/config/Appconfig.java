package baseball.config;

import baseball.controller.BaseballController;
import baseball.generator.BaseballNumberGenerator;
import baseball.generator.BaseballNumberGeneratorImpl;
import baseball.validation.InputNumberValidation;
import baseball.validation.InputNumberValidationImpl;
import baseball.validation.InputUserChoiceValidation;
import baseball.validation.InputUserChoiceValidationImpl;
import baseball.view.InputView;
import baseball.view.OutputView;

public class Appconfig {
    public BaseballController baseballController() {
        return new BaseballController(inputView(), outputView(), inputValidation(),baseballNumberGenerator(),inputUserChoiceValidation());
    }

    public InputNumberValidation inputValidation(){
        return new InputNumberValidationImpl();
    }

    public BaseballNumberGenerator baseballNumberGenerator(){
        return new BaseballNumberGeneratorImpl();
    }

    public InputUserChoiceValidation inputUserChoiceValidation(){
        return new InputUserChoiceValidationImpl();
    }
    public InputView inputView() {
        return new InputView();
    }

    public OutputView outputView() {
        return new OutputView();
    }

}
