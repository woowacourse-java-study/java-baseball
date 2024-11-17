package baseball.config.io.writer;

import baseball.io.writer.SystemWriter;
import baseball.io.writer.Writer;

public class DefaultWriterConfig implements WriterConfig {
	
	private final Writer writer;
	
	public DefaultWriterConfig() {
		this.writer = new SystemWriter();
	}
	
	@Override
	public Writer getWriter() {
		return writer;
	}
}
