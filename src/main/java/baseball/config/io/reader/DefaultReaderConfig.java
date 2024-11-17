package baseball.config.io.reader;

import baseball.io.reader.MissionUtilsReader;
import baseball.io.reader.Reader;

public class DefaultReaderConfig implements ReaderConfig {
	
	private final Reader reader;
	
	public DefaultReaderConfig() {
		this.reader = new MissionUtilsReader();
	}
	
	@Override
	public Reader getReader() {
		return reader;
	}
}
