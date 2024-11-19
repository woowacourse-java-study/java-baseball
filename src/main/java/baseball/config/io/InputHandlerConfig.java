package baseball.config.io;

import baseball.config.io.reader.ReaderConfig;
import baseball.config.io.writer.WriterConfig;
import baseball.io.input.InputHandler;
import baseball.io.input.InputParser;
import baseball.io.input.InputValidator;

public class InputHandlerConfig {
	
	private final InputHandler inputHandler;
	
	public InputHandlerConfig(ReaderConfig readerConfig, WriterConfig writerConfig) {
		this.inputHandler = new InputHandler(
				readerConfig.getReader(),
				writerConfig.getWriter(),
				new InputParser(),
				new InputValidator()
		);
	}
	
	public InputHandler getInputHandler() {
		return inputHandler;
	}
}
