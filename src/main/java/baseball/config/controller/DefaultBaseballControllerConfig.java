package baseball.config.controller;

import baseball.config.io.InputHandlerConfig;
import baseball.config.io.OutputHandlerConfig;
import baseball.config.service.BaseballGameFactoryConfig;
import baseball.config.service.RetryHandlerConfig;
import baseball.controller.BaseballController;
import baseball.controller.BaseballControllerReplayProxy;
import baseball.controller.DefaultBaseballController;

public class DefaultBaseballControllerConfig implements BaseballControllerConfig {
	
	private final BaseballController baseballController;
	
	public DefaultBaseballControllerConfig(
			InputHandlerConfig inputHandlerConfig,
			OutputHandlerConfig outputHandlerConfig,
			RetryHandlerConfig retryHandlerConfig,
			BaseballGameFactoryConfig baseballGameFactoryConfig
	) {
		
		BaseballController defaultBaseballController = new DefaultBaseballController(
				inputHandlerConfig.getInputHandler(),
				outputHandlerConfig.getOutputHandler(),
				baseballGameFactoryConfig.getBaseballGameFactory()
		);
		this.baseballController = new BaseballControllerReplayProxy(
				defaultBaseballController,
				inputHandlerConfig.getInputHandler(),
				retryHandlerConfig.getRetryHandler()
		);
	}
	
	@Override
	public BaseballController getbaseballController() {
		return baseballController;
	}
}
