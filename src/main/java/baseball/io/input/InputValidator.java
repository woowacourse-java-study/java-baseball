package baseball.io.input;

import baseball.common.exception.BaseballExceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputValidator {
	
	private static final Pattern BASEBALL_NUMBERS_PATTERN = Pattern.compile("^\\d+$");
	private static final Pattern REPLAY_DECISION_PATTERN = Pattern.compile("^[12]$");
	
	public void validateBaseballNumbers(String input) {
		Matcher matcher = BASEBALL_NUMBERS_PATTERN.matcher(input);
		if (!matcher.matches()) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
	
	public void validateReplayDecision(String input) {
		Matcher matcher = REPLAY_DECISION_PATTERN.matcher(input);
		if (!matcher.matches()) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
}
