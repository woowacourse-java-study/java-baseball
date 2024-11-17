package baseball.io.output;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRoundResult;
import baseball.io.writer.Writer;

public class OutputHandler {
	
	private final Writer writer;
	
	public OutputHandler(Writer writer) {
		this.writer = writer;
	}
	
	public void handleRoundResult(BaseballRoundResult baseballRoundResult) {
		StringBuilder sb = new StringBuilder();
		if (baseballRoundResult.isNothing()) {
			sb.append("낫싱");
		} else {
			appendBallCount(baseballRoundResult, sb);
			appendStrikeCount(baseballRoundResult, sb);
		}
		sb.append("\n");
		writer.write(sb.toString());
	}
	
	private static void appendStrikeCount(BaseballRoundResult baseballRoundResult, StringBuilder sb) {
		if (baseballRoundResult.strikeCount() != 0) {
			sb.append(baseballRoundResult.strikeCount()).append("스트라이크 ");
		}
	}
	
	private static void appendBallCount(BaseballRoundResult baseballRoundResult, StringBuilder sb) {
		if (baseballRoundResult.ballCount() != 0) {
			sb.append(baseballRoundResult.ballCount()).append("볼 ");
		}
	}
	
	public void handleBaseballEnd() {
		writer.write("%d개의 숫자를 모두 맞히셨습니다! 게임 종료\n".formatted(BaseballNumbers.BASEBALL_NUMBERS_SIZE));
	}
}
