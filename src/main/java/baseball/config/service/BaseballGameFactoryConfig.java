package baseball.config.service;

import baseball.config.service.numberPicker.NumberPickerConfig;
import baseball.service.baseballGameFactory.BaseballGameFactory;
import baseball.service.baseballGameFactory.DefaultBaseballGameFactory;

public class BaseballGameFactoryConfig {
	
	private final BaseballGameFactory baseballGameFactory;
	
	public BaseballGameFactoryConfig(
			NumberPickerConfig numberPickerConfig,
			RetryHandlerConfig retryHandlerConfig
	) {
		this.baseballGameFactory = new DefaultBaseballGameFactory(
				numberPickerConfig.getNumberPicker(),
				retryHandlerConfig.getRetryHandler()
		);
	}
	
	public BaseballGameFactory getBaseballGameFactory() {
		return baseballGameFactory;
	}
}
