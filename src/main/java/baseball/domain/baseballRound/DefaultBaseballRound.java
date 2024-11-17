package baseball.domain.baseballRound;

import baseball.common.validator.ParamsValidator;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRoundResult;
import baseball.service.NumberProvider;

import java.util.List;

public class DefaultBaseballRound implements BaseballRound {
	
	private final BaseballNumbers baseballNumbers;
	
	public DefaultBaseballRound(BaseballNumbers baseballNumbers) {
		ParamsValidator.validateParamsNotNull(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}
	
	@Override
	public BaseballRoundResult playOneRound(NumberProvider numberProvider) {
		List<Integer> numbers = numberProvider.provide();
		BaseballNumbers tryBaseballNumbers = BaseballNumbers.from(numbers);
		return baseballNumbers.calculateStrikeBall(tryBaseballNumbers);
	}
}
