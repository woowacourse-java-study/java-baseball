package baseball.domain;

import baseball.service.NumberProvider;

import java.util.List;

public class BaseballRound {
	
	public static BaseballRoundResult playOneRound(BaseballNumbers targetBaseballNumbers, NumberProvider numberProvider) {
		List<Integer> numbers = numberProvider.provide();
		BaseballNumbers tryBaseballNumbers = BaseballNumbers.from(numbers);
		return targetBaseballNumbers.getRoundResult(tryBaseballNumbers);
	}
}
