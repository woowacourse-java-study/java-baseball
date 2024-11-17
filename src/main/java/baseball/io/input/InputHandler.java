package baseball.io.input;

import baseball.io.reader.Reader;
import baseball.io.writer.Writer;

import java.util.List;

public class InputHandler {
	
	private final Reader reader;
	private final Writer writer;
	private final InputParser inputParser;
	
	public InputHandler(Reader reader, Writer writer, InputParser inputParser) {
		this.reader = reader;
		this.writer = writer;
		this.inputParser = inputParser;
	}
	
	public List<Integer> getBaseballNumbers() {
		writer.write("숫자를 입력해주세요 : ");
		String input = reader.readLineAsString();
		return inputParser.parseBaseballNumbers(input);
	}
}
