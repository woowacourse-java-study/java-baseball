package baseball.io.input;

import baseball.common.exception.BaseballExceptions;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
	
	public List<Integer> parseBaseballNumbers(String input) {
		// TODO : 예외 처리
		List<Integer> baseballNumbers = new ArrayList<>();
		for (char ch : input.toCharArray()) {
			baseballNumbers.add(Integer.parseInt(String.valueOf(ch)));
		}
		return baseballNumbers;
	}
	
	public boolean parseReplayDecsion(String input) {
		// TODO : 예외 처리
		if (input.equals("1")) {
			return true;
		}
		if (input.equals("2")) {
			return false;
		}
		throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
	}
}
