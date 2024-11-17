package baseball.common.exception;

import baseball.io.writer.Writer;

public class ExceptionHandler {
	
	private static final String EXCEPTION_MESSAGE_PREFIX = "\n[ERROR] ";
	
	private final Writer writer;
	
	public ExceptionHandler(final Writer writer) {
		this.writer = writer;
	}
	
	public void handleException(final Exception exception) {
		writer.write(EXCEPTION_MESSAGE_PREFIX + exception.getMessage() + "\n");
	}
}
