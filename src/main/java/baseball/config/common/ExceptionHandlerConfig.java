package baseball.config.common;

import baseball.common.exception.ExceptionHandler;
import baseball.config.io.writer.WriterConfig;

public class ExceptionHandlerConfig {
	
	private final ExceptionHandler exceptionHandler;
	
	public ExceptionHandlerConfig(WriterConfig writerConfig) {
		this.exceptionHandler = new ExceptionHandler(writerConfig.getWriter());
	}
	
	public ExceptionHandler getExceptionHandler() {
		return exceptionHandler;
	}
}
