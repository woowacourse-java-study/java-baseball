package baseball.io.input;

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
}
