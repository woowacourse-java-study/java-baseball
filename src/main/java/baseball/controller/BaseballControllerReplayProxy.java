package baseball.controller;

import baseball.service.RetryHandler;
import baseball.io.input.InputHandler;

public class BaseballControllerReplayProxy implements BaseballController {
	
	private final BaseballController targetBaseballController;
	private final InputHandler inputHandler;
	private final RetryHandler retryHandler;
	
	public BaseballControllerReplayProxy(
			BaseballController targetBaseballController,
			InputHandler inputHandler,
			RetryHandler retryHandler
	) {
		this.targetBaseballController = targetBaseballController;
		this.inputHandler = inputHandler;
		this.retryHandler = retryHandler;
	}
	
	@Override
	public void run() {
		do {
			targetBaseballController.run();
		} while (retryHandler.tryUntilSuccess(inputHandler::getReplayDecision));
	}
}
