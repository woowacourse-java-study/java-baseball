package baseball.domain;

import baseball.common.exception.BaseballExceptions;
import baseball.common.validator.ParamsValidator;
import baseball.service.numberPicker.NumberPicker;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
	
	private static final int BASEBALL_NUMBERS_SIZE = 3;
	
	private final List<BaseballNumber> baseballNumbers;
	
	public BaseballNumbers(List<BaseballNumber> baseballNumbers) {
		ParamsValidator.validateParamsNotNull(baseballNumbers);
		validate(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}
	
	private static void validate(List<BaseballNumber> baseballNumbers) {
		if (baseballNumbers.size() != BASEBALL_NUMBERS_SIZE) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
	
	public static BaseballNumbers from(NumberPicker numberPicker) {
		List<BaseballNumber> baseballNumbers = new ArrayList<>();
		for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
			baseballNumbers.add(BaseballNumber.from(numberPicker));
		}
		return new BaseballNumbers(baseballNumbers);
	}
	
	public static BaseballNumbers from(List<Integer> numbers) {
		return new BaseballNumbers(numbers.stream()
				.map(BaseballNumber::from)
				.toList());
	}
}
