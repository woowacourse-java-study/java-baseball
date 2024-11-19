package baseball.controller;

import baseball.dto.ResultDTO;
import baseball.generator.BaseballNumberGenerator;
import baseball.model.Baseball;
import baseball.model.Referee;
import baseball.model.Result;
import baseball.validation.InputNumberValidation;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballController {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputNumberValidation inputNumberValidationImpl;
    private final BaseballNumberGenerator baseballNumberGeneratorImpl;


    public BaseballController(InputView inputView, OutputView outputView, InputNumberValidation inputNumberValidationImpl, BaseballNumberGenerator baseballNumberGeneratorImpl) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputNumberValidationImpl = inputNumberValidationImpl;
        this.baseballNumberGeneratorImpl = baseballNumberGeneratorImpl;
    }

    public void start() {
        List<Integer> baseballNumber = baseballNumberGeneratorImpl.generate();
        Baseball baseball = new Baseball(baseballNumber);
        inputView.printBaseballGameStart();

        Result result;
        do {
            String userNumber = inputNumberValidationImpl.validate(inputView.inputBasebalNumber());
            result = new Referee(baseball, userNumber).getResult();
            ResultDTO resultDTO = new ResultDTO(result.getStrikes(), result.getBalls());
            outputView.printResult(resultDTO);
        } while (result.getStrikes() != 3);
    }
}
