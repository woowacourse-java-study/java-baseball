package baseball.testutil;

import baseball.service.numberPicker.NumberPicker;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NumberPickerFake implements NumberPicker {
	
	private final List<Integer> numbers = new ArrayList<>();
	private int numberCount = 0;
	
	public void setNumbers(Integer... numbers) {
		this.numbers.addAll(Arrays.asList(numbers));
	}
	
	@Override
	public int pickNumberInRange(int startInclusive, int endInclusive) {
		return numbers.get(numberCount++);
	}
}
