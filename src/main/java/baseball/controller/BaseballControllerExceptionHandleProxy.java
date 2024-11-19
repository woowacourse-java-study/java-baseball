package baseball.controller;

import baseball.common.exception.ExceptionHandler;

public class BaseballControllerExceptionHandleProxy implements BaseballController {
	
	private final BaseballController targetBaseballController;
	private final ExceptionHandler exceptionHandler;
	
	public BaseballControllerExceptionHandleProxy(BaseballController targetBaseballController, ExceptionHandler exceptionHandler) {
		this.targetBaseballController = targetBaseballController;
		this.exceptionHandler = exceptionHandler;
	}
	
	@Override
	public void run() {
		try {
			targetBaseballController.run();
		} catch (RuntimeException e) {
			exceptionHandler.handleException(e);
		}
	}
}
