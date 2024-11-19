package baseball.io.input;

import java.util.ArrayList;
import java.util.List;

public class InputParser {
	
	public List<Integer> parseBaseballNumbers(String input) {
		List<Integer> baseballNumbers = new ArrayList<>();
		for (char ch : input.toCharArray()) {
			baseballNumbers.add(Integer.parseInt(String.valueOf(ch)));
		}
		return baseballNumbers;
	}
	
	public boolean parseReplayDecsion(String input) {
		return input.equals("1");
	}
}
