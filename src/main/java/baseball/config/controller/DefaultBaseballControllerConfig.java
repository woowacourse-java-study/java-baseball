package baseball.config.controller;

import baseball.config.common.ExceptionHandlerConfig;
import baseball.config.io.InputHandlerConfig;
import baseball.config.io.OutputHandlerConfig;
import baseball.config.service.numberPicker.NumberPickerConfig;
import baseball.controller.BaseballController;
import baseball.controller.BaseballControllerExceptionHandleProxy;
import baseball.controller.BaseballControllerReplayProxy;
import baseball.controller.DefaultBaseballController;

public class DefaultBaseballControllerConfig implements BaseballControllerConfig {
	
	private final BaseballController baseballController;
	
	public DefaultBaseballControllerConfig(
			InputHandlerConfig inputHandlerConfig,
			OutputHandlerConfig outputHandlerConfig,
			NumberPickerConfig numberPickerConfig,
			ExceptionHandlerConfig exceptionHandlerConfig
	) {
		BaseballController defaultBaseballController = new DefaultBaseballController(
				inputHandlerConfig.getInputHandler(),
				outputHandlerConfig.getOutputHandler(),
				numberPickerConfig.getNumberPicker()
		);
		BaseballControllerReplayProxy baseballControllerReplayProxy = new BaseballControllerReplayProxy(
				defaultBaseballController,
				inputHandlerConfig.getInputHandler()
		);
		this.baseballController = new BaseballControllerExceptionHandleProxy(
				baseballControllerReplayProxy,
				exceptionHandlerConfig.getExceptionHandler()
		);
	}
	
	@Override
	public BaseballController getbaseballController() {
		return baseballController;
	}
}
