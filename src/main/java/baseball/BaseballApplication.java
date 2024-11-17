package baseball;

import baseball.config.controller.BaseballControllerConfig;
import baseball.config.controller.DefaultBaseballControllerConfig;
import baseball.config.io.InputHandlerConfig;
import baseball.config.io.OutputHandlerConfig;
import baseball.config.io.reader.DefaultReaderConfig;
import baseball.config.io.reader.ReaderConfig;
import baseball.config.io.writer.DefaultWriterConfig;
import baseball.config.io.writer.WriterConfig;
import baseball.config.service.BaseballGameFactoryConfig;
import baseball.config.service.RetryHandlerConfig;
import baseball.config.service.numberPicker.DefaultNumberPickerConfig;
import baseball.config.service.numberPicker.NumberPickerConfig;
import baseball.controller.BaseballController;

public class BaseballApplication {
	
	private final BaseballController baseballController;
	
	public BaseballApplication() {
		WriterConfig writerConfig = new DefaultWriterConfig();
		RetryHandlerConfig retryHandlerConfig = new RetryHandlerConfig(writerConfig);
		BaseballControllerConfig baseballControllerConfig = new DefaultBaseballControllerConfig(
				new InputHandlerConfig(new DefaultReaderConfig(), writerConfig),
				new OutputHandlerConfig(writerConfig),
				retryHandlerConfig,
				createBaseballGameFactoryConfig(retryHandlerConfig)
		);
		this.baseballController = baseballControllerConfig.getbaseballController();
	}
	
	private static BaseballGameFactoryConfig createBaseballGameFactoryConfig(RetryHandlerConfig retryHandlerConfig) {
		NumberPickerConfig numberPickerConfig = new DefaultNumberPickerConfig();
		return new BaseballGameFactoryConfig(numberPickerConfig, retryHandlerConfig);
	}
	
	public void run() {
		baseballController.run();
	}
}
