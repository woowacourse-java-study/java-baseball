package baseball.controller;

import baseball.common.dto.BaseballRoundResult;
import baseball.domain.BaseballGame;
import baseball.io.input.InputHandler;
import baseball.io.output.OutputHandler;
import baseball.service.baseballGameFactory.BaseballGameFactory;

public class DefaultBaseballController implements BaseballController {
	
	private final InputHandler inputHandler;
	private final OutputHandler outputHandler;
	private final BaseballGameFactory baseballGameFactory;
	
	public DefaultBaseballController(
			InputHandler inputHandler,
			OutputHandler outputHandler,
			BaseballGameFactory baseballGameFactory
	) {
		this.inputHandler = inputHandler;
		this.outputHandler = outputHandler;
		this.baseballGameFactory = baseballGameFactory;
	}
	
	@Override
	public void run() {
		outputHandler.handleBaseballStart();
		BaseballGame baseballGame = baseballGameFactory.create();
		BaseballRoundResult playResult = baseballGame.play(
				inputHandler::getBaseballNumbers,
				outputHandler::handleRoundResult
		);
		outputHandler.handleBaseballEnd(playResult);
	}
}
