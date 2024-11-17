package baseball.io.input;

import baseball.io.reader.Reader;
import baseball.io.writer.Writer;

import java.util.List;

public class InputHandler {
	
	private final Reader reader;
	private final Writer writer;
	private final InputParser inputParser;
	private final InputValidator inputValidator;
	
	public InputHandler(Reader reader, Writer writer, InputParser inputParser, InputValidator inputValidator) {
		this.reader = reader;
		this.writer = writer;
		this.inputParser = inputParser;
		this.inputValidator = inputValidator;
	}
	
	public List<Integer> getBaseballNumbers() {
		writer.write("숫자를 입력해주세요 : ");
		String input = reader.readLineAsString();
		inputValidator.validateBaseballNumbers(input);
		return inputParser.parseBaseballNumbers(input);
	}
	
	public boolean getReplayDecision() {
		writer.write("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.\n");
		String input = reader.readLineAsString();
		inputValidator.validateReplayDecision(input);
		return inputParser.parseReplayDecsion(input);
	}
}
