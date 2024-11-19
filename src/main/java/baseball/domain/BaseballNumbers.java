package baseball.domain;

import baseball.common.dto.BaseballRoundResult;
import baseball.common.exception.BaseballExceptions;
import baseball.common.validator.ParamsValidator;
import baseball.service.numberPicker.NumberPicker;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class BaseballNumbers {
	
	public static final int BASEBALL_NUMBERS_COUNT = 3;
	
	private final List<BaseballNumber> baseballNumbers;
	
	private BaseballNumbers(List<BaseballNumber> baseballNumbers) {
		ParamsValidator.validateParamsNotNull(baseballNumbers);
		validate(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}
	
	private static void validate(List<BaseballNumber> baseballNumbers) {
		if (baseballNumbers.size() != BASEBALL_NUMBERS_COUNT) {
			throw BaseballExceptions.BASEBALL_NUMBERS_COUNT_ILLEGAL.get();
		}
		if (isNotUnique(baseballNumbers)) {
			throw BaseballExceptions.BASEBALL_NUMBERS_DUPLICATED.get();
		}
	}
	
	private static boolean isNotUnique(List<BaseballNumber> baseballNumbers) {
		return new HashSet<>(baseballNumbers).size() != baseballNumbers.size();
	}
	
	public static BaseballNumbers from(NumberPicker numberPicker) {
		List<BaseballNumber> baseballNumbers = new ArrayList<>();
		while (baseballNumbers.size() < BASEBALL_NUMBERS_COUNT) {
			BaseballNumber baseballNumber = BaseballNumber.from(numberPicker);
			if (!baseballNumbers.contains(baseballNumber)) {
				baseballNumbers.add(baseballNumber);
			}
		}
		return new BaseballNumbers(baseballNumbers);
	}
	
	public static BaseballNumbers from(List<Integer> numbers) {
		return new BaseballNumbers(numbers.stream()
				.map(BaseballNumber::from)
				.toList());
	}
	
	public static boolean isAllStrike(int strikeCount) {
		return BASEBALL_NUMBERS_COUNT == strikeCount;
	}
	
	public BaseballRoundResult calculateStrikeBall(BaseballNumbers targetBaseballNumbers) {
		return new BaseballRoundResult(
				calculateStrikeCount(targetBaseballNumbers),
				calculateBallCount(targetBaseballNumbers)
		);
	}
	
	private int calculateStrikeCount(BaseballNumbers targetBaseballNumbers) {
		int strikeCount = 0;
		for (int i = 0; i < BASEBALL_NUMBERS_COUNT; i++) {
			BaseballNumber baseballNumber = baseballNumbers.get(i);
			if (targetBaseballNumbers.containsInExactPosition(baseballNumber, i)) {
				strikeCount++;
			}
		}
		return strikeCount;
	}
	
	private int calculateBallCount(BaseballNumbers targetBaseballNumbers) {
		int ballCount = 0;
		for (int i = 0; i < BASEBALL_NUMBERS_COUNT; i++) {
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
		for (int i = 0; i < BASEBALL_NUMBERS_COUNT; i++) {
			if (baseballNumbers.get(i).equals(baseballNumber) && i != position) {
				return true;
			}
		}
		return false;
	}
}
