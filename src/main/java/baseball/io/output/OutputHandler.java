package baseball.io.output;

import baseball.common.dto.BaseballRoundResult;
import baseball.io.writer.Writer;

public class OutputHandler {
	
	private final Writer writer;
	private final OutputParser outputParser;
	
	public OutputHandler(Writer writer, OutputParser outputParser) {
		this.writer = writer;
		this.outputParser = outputParser;
	}
	
	public void handleBaseballStart() {
		writer.write("숫자 야구 게임을 시작합니다.\n");
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
