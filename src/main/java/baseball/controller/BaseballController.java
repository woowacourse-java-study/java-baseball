package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRoundResult;
import baseball.io.input.InputHandler;
import baseball.domain.BaseballRound;
import baseball.io.output.OutputHandler;
import baseball.service.NumberProvider;
import baseball.service.numberPicker.NumberPicker;

public class BaseballController implements Controller {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final NumberPicker numberPicker;
	
	public BaseballController(InputHandler inputHandler, OutputHandler outputHandler, NumberPicker numberPicker) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.numberPicker = numberPicker;
	}
	
	@Override
	public void run() {
		BaseballNumbers targetBaseballNumbers = BaseballNumbers.from(numberPicker);
		while (true) {
			BaseballRoundResult baseballRoundResult = BaseballRound.playOneRound(targetBaseballNumbers, inputHandler::getBaseballNumbers);
			if (BaseballNumbers.isAllStrike(baseballRoundResult.strikeCount())) {
				break;
			} else {
				outputHandler.handleRoundResult(baseballRoundResult);
			}
		}
		outputHandler.handleBaseballEnd();
	}
}
