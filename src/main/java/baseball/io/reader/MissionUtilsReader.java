package baseball.io.reader;

import baseball.common.exception.BaseballExceptions;
import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;

public class MissionUtilsReader implements Reader {
	
	@Override
	public List<String> readLineAsStrings(final String spliter) {
		try {
			String input = Console.readLine();
			return Arrays.asList(input.split(spliter));
		} catch (IllegalArgumentException e) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
	
	@Override
	public String readLineAsString() {
		try {
			return Console.readLine();
		} catch (IllegalArgumentException e) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
}
