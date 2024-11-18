package baseball;

import baseball.config.common.ExceptionHandlerConfig;
import baseball.config.controller.BaseballControllerConfig;
import baseball.config.controller.DefaultBaseballControllerConfig;
import baseball.config.io.InputHandlerConfig;
import baseball.config.io.OutputHandlerConfig;
import baseball.config.io.reader.DefaultReaderConfig;
import baseball.config.io.writer.DefaultWriterConfig;
import baseball.config.io.writer.WriterConfig;
import baseball.config.service.numberPicker.DefaultNumberPickerConfig;
import baseball.controller.BaseballController;

public class BaseballApplication {
	
	private final BaseballController baseballController;
	
	public BaseballApplication() {
		WriterConfig writerConfig = new DefaultWriterConfig();
		ExceptionHandlerConfig exceptionHandlerConfig = new ExceptionHandlerConfig(writerConfig);
		BaseballControllerConfig baseballControllerConfig = new DefaultBaseballControllerConfig(
				new InputHandlerConfig(new DefaultReaderConfig(), writerConfig),
				new OutputHandlerConfig(writerConfig),
				new DefaultNumberPickerConfig(),
				exceptionHandlerConfig
		);
		this.baseballController = baseballControllerConfig.getbaseballController();
	}
	
	public void run() {
		baseballController.run();
	}
}
