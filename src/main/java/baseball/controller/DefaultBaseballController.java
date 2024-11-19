package baseball.controller;

import baseball.common.dto.BaseballRoundResult;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRound;
import baseball.io.input.InputHandler;
import baseball.io.output.OutputHandler;
import baseball.service.numberPicker.NumberPicker;

public class DefaultBaseballController implements BaseballController {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final NumberPicker numberPicker;
	
	public DefaultBaseballController(InputHandler inputHandler, OutputHandler outputHandler, NumberPicker numberPicker) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.numberPicker = numberPicker;
	}
	
	@Override
	public void run() {
		outputHandler.handleBaseballStart();
		BaseballNumbers baseballNumbers = BaseballNumbers.from(numberPicker);
		BaseballRound baseballRound = new BaseballRound(baseballNumbers);
		BaseballGame baseballGame = new BaseballGame(baseballRound);
		BaseballRoundResult playResult = baseballGame.play(
				inputHandler::getBaseballNumbers,
				outputHandler::handleRoundResult
		);
		outputHandler.handleBaseballEnd(playResult);
	}
}
