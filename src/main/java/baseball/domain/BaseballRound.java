package baseball.domain;

import baseball.common.dto.BaseballRoundResult;
import baseball.common.validator.ParamsValidator;
import baseball.service.NumberProvider;

import java.util.List;

public class BaseballRound {
	
	private final BaseballNumbers baseballNumbers;
	
	public BaseballRound(BaseballNumbers baseballNumbers) {
		ParamsValidator.validateParamsNotNull(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}
	
	public BaseballRoundResult playOneRound(NumberProvider numberProvider) {
		List<Integer> numbers = numberProvider.provide();
		BaseballNumbers tryBaseballNumbers = BaseballNumbers.from(numbers);
		return baseballNumbers.calculateStrikeBall(tryBaseballNumbers);
	}
}
