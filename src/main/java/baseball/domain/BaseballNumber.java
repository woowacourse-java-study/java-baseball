package baseball.domain;

import baseball.common.exception.BaseballExceptions;
import baseball.service.numberPicker.NumberPicker;

import java.util.Objects;

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
			throw BaseballExceptions.BASEBALL_NUMBER_RANGE_ILLEGAL.get();
		}
	}
	
	public static BaseballNumber from(NumberPicker numberPicker) {
		int number = numberPicker.pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
		return new BaseballNumber(number);
	}
	
	public static BaseballNumber from(int number) {
		return new BaseballNumber(number);
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof BaseballNumber that)) return false;
		return number == that.number;
	}
	
	@Override
	public int hashCode() {
		return Objects.hashCode(number);
	}
}
