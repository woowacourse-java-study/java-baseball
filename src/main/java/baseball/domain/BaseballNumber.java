package baseball.domain;

import baseball.common.exception.BaseballExceptions;
import baseball.service.numberPicker.NumberPicker;

import java.util.List;

public class BaseballNumber {
	
	private static final int MIN_NUMBER = 1;
	private static final int MAX_NUMBER = 9;

	private final int number;
	
	private BaseballNumber(int number) {
		validate(number);
		this.number = number;
	}
	
	private static void validate(int number) {
		if (number < MIN_NUMBER || number > MAX_NUMBER) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
	
	public static BaseballNumber generate(NumberPicker numberPicker) {
		int number = numberPicker.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		return new BaseballNumber(number);
	}
}
