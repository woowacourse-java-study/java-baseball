package baseball.controller;

import baseball.generator.BaseballNumberGenerator;
import baseball.model.Baseball;
import baseball.validation.InputValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidation inputValidationImpl;
    private final BaseballNumberGenerator baseballNumberGeneratorImpl;


    public BaseballController(InputView inputView, OutputView outputView, InputValidation inputValidationImpl, BaseballNumberGenerator baseballNumberGeneratorImpl) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidationImpl = inputValidationImpl;
        this.baseballNumberGeneratorImpl = baseballNumberGeneratorImpl;
    }

    public void start() {
        List<Integer> baseballNumber = baseballNumberGeneratorImpl.generate();
        Baseball baseball = new Baseball(baseballNumber);
        inputValidationImpl.vlalidate(inputView.inputBasebalNumber());

    }
}
