package baseball.config.io;

import baseball.config.io.writer.WriterConfig;
import baseball.io.output.OutputHandler;
import baseball.io.output.OutputParser;

public class OutputHandlerConfig {
	
	private final OutputHandler outputHandler;
	
	public OutputHandlerConfig(WriterConfig writerConfig) {
		this.outputHandler = new OutputHandler(
				writerConfig.getWriter(),
				new OutputParser()
		);
	}
	
	public OutputHandler getOutputHandler() {
		return outputHandler;
	}
}
