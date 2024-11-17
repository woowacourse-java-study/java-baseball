package baseball.domain;

import baseball.common.exception.BaseballExceptions;
import baseball.common.validator.ParamsValidator;
import baseball.service.numberPicker.NumberPicker;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseballNumbers {
	
	public static final int BASEBALL_NUMBERS_SIZE = 3;
	
	private final List<BaseballNumber> baseballNumbers;
	
	private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
		ParamsValidator.validateParamsNotNull(baseballNumbers);
		validate(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}
	
	private static void validate(List<BaseballNumber> baseballNumbers) {
		if (baseballNumbers.size() != BASEBALL_NUMBERS_SIZE) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
		if (isNotUnique(baseballNumbers)) {
			throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
		}
	}
	
	private static boolean isNotUnique(List<BaseballNumber> baseballNumbers) {
		return new HashSet<>(baseballNumbers).size() != baseballNumbers.size();
	}
	
	public static BaseballNumbers from(NumberPicker numberPicker) {
		Set<BaseballNumber> baseballNumbers = new HashSet<>();
		while(baseballNumbers.size() < BASEBALL_NUMBERS_SIZE) {
			baseballNumbers.add(BaseballNumber.from(numberPicker));
		}
		return new BaseballNumbers(baseballNumbers.stream().toList());
	}
	
	public static BaseballNumbers from(List<Integer> numbers) {
		return new BaseballNumbers(numbers.stream()
				.map(BaseballNumber::from)
				.toList());
	}
	
	public static boolean isAllStrike(int strikeCount) {
		return BASEBALL_NUMBERS_SIZE == strikeCount;
	}
	
	public BaseballRoundResult calculateStrikeBall(BaseballNumbers targetBaseballNumbers) {
		return new BaseballRoundResult(
				calculateStrikeCount(targetBaseballNumbers),
				calculateBallCount(targetBaseballNumbers)
		);
	}
	
	private int calculateStrikeCount(BaseballNumbers targetBaseballNumbers) {
		int strikeCount = 0;
		for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
			BaseballNumber baseballNumber = baseballNumbers.get(i);
			if (targetBaseballNumbers.containsInExactPosition(baseballNumber, i)) {
				strikeCount++;
			}
		}
		return strikeCount;
	}
	
	private int calculateBallCount(BaseballNumbers targetBaseballNumbers) {
		int ballCount = 0;
		for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
			BaseballNumber baseballNumber = baseballNumbers.get(i);
			if (targetBaseballNumbers.containsInOtherPosition(baseballNumber, i)) {
				ballCount++;
			}
		}
		return ballCount;
	}
	
	private boolean containsInExactPosition(BaseballNumber baseballNumber, int position) {
		return baseballNumbers.get(position).equals(baseballNumber);
	}
	
	private boolean containsInOtherPosition(BaseballNumber baseballNumber, int position) {
		for (int i = 0; i < BASEBALL_NUMBERS_SIZE; i++) {
			if (baseballNumbers.get(i).equals(baseballNumber) && i != position) {
				return true;
			}
		}
		return false;
	}
}
