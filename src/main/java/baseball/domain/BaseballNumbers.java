package baseball.domain;

import baseball.common.exception.BaseballExceptions;
import baseball.common.validator.ParamsValidator;
import baseball.service.numberPicker.NumberPicker;

import java.util.ArrayList;
import java.util.List;

public class BaseballNumbers {
	
	public static final int BASEBALL_NUMBERS_SIZE = 3;
	
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
	
	public static boolean isAllStrike(int strikeCount) {
		return BASEBALL_NUMBERS_SIZE == strikeCount;
	}
	
	public BaseballRoundResult getRoundResult(BaseballNumbers targetBaseballNumbers) {
		int strikeCount = 0;
		int ballCount = 0;
		for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
			for (int j = 0; j < BASEBALL_NUMBERS_SIZE; j++) {
				BaseballNumber baseballNumber = baseballNumbers.get(i);
				BaseballNumber targetBaseballNumber = targetBaseballNumbers.baseballNumbers.get(i);
				if (baseballNumber.isSame(targetBaseballNumber) && i == j) {
					strikeCount++;
					continue;
				}
				if (baseballNumber.isSame(targetBaseballNumber) && i != j) {
					ballCount++;
				}
			}
		}
		return new BaseballRoundResult(strikeCount, ballCount);
	}
}
