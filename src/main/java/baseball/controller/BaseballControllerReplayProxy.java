package baseball.controller;

import baseball.io.input.InputHandler;

public class BaseballControllerReplayProxy implements BaseballController {
	
	private final BaseballController targetBaseballController;
	private final InputHandler inputHandler;
	
	public BaseballControllerReplayProxy(BaseballController targetBaseballController, InputHandler inputHandler) {
		this.targetBaseballController = targetBaseballController;
		this.inputHandler = inputHandler;
	}
	
	@Override
	public void run() {
		do {
			targetBaseballController.run();
		} while (inputHandler.getReplayDecision());
	}
}
