package baseball.io.output;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRoundResult;
import baseball.io.writer.Writer;

public class OutputHandler {
	
	private final OutputParser outputParser;
	private final Writer writer;
	
	public OutputHandler(OutputParser outputParser, Writer writer) {
		this.outputParser = outputParser;
		this.writer = writer;
	}
	
	public void handleRoundResult(BaseballRoundResult baseballRoundResult) {
		String output = outputParser.parseRoundResult(baseballRoundResult);
		writer.write(output);
	}
	
	public void handleBaseballEnd(BaseballRoundResult baseballRoundResult) {
		String output = "%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n".formatted(baseballRoundResult.strikeCount());
		writer.write(output);
	}
}
