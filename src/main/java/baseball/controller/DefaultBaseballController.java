package baseball.controller;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRoundResult;
import baseball.io.input.InputHandler;
import baseball.domain.BaseballGame;
import baseball.io.output.OutputHandler;
import baseball.service.BaseballService;
import baseball.service.numberPicker.NumberPicker;

public class DefaultBaseballController implements BaseballController {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final BaseballService baseballService;
	
	public DefaultBaseballController(InputHandler inputHandler, OutputHandler outputHandler, BaseballService baseballService) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.baseballService = baseballService;
	}
	
	@Override
	public void run() {
		BaseballGame baseballGame = baseballService.createBaseballGame();
		BaseballRoundResult playResult = baseballGame.play(
				inputHandler::getBaseballNumbers,
				outputHandler::handleRoundResult
		);
		outputHandler.handleBaseballEnd(playResult);
	}
}
