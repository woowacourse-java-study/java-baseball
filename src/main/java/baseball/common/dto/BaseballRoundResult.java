package baseball.common.dto;

public record BaseballRoundResult(
		int strikeCount,
		int ballCount
) {
	
	public boolean isNothing() {
		return strikeCount == 0 && ballCount == 0;
	}
}
