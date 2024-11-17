package baseball.config.service;

import baseball.common.exception.ExceptionHandler;
import baseball.config.io.writer.WriterConfig;
import baseball.service.RetryHandler;

public class RetryHandlerConfig {
	
	private final RetryHandler retryHandler;
	
	public RetryHandlerConfig(WriterConfig writerConfig) {
		this.retryHandler = new RetryHandler(new ExceptionHandler(writerConfig.getWriter()));
	}
	
	public RetryHandler getRetryHandler() {
		return retryHandler;
	}
}
