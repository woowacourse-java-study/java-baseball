package baseball.io.output;

import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRoundResult;

public class OutputParser {
	
	public String parseRoundResult(BaseballRoundResult baseballRoundResult) {
		StringBuilder sb = new StringBuilder();
		if (baseballRoundResult.isNothing()) {
			sb.append("낫싱");
		} else {
			appendBallCount(baseballRoundResult, sb);
			appendStrikeCount(baseballRoundResult, sb);
		}
		sb.append("\n");
		return sb.toString();
	}
	
	private static void appendBallCount(BaseballRoundResult baseballRoundResult, StringBuilder sb) {
		if (baseballRoundResult.ballCount() != 0) {
			sb.append(baseballRoundResult.ballCount()).append("볼 ");
		}
	}
	
	private static void appendStrikeCount(BaseballRoundResult baseballRoundResult, StringBuilder sb) {
		if (baseballRoundResult.strikeCount() != 0) {
			sb.append(baseballRoundResult.strikeCount()).append("스트라이크 ");
		}
	}
}
