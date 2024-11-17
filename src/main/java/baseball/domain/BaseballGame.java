package baseball.domain;

import baseball.common.validator.ParamsValidator;
import baseball.service.NumberProvider;
import baseball.service.RoundResultConsumer;

import java.util.List;

public class BaseballGame {
	
	private final BaseballNumbers baseballNumbers;
	
	public BaseballGame(BaseballNumbers baseballNumbers) {
		ParamsValidator.validateParamsNotNull(baseballNumbers);
		this.baseballNumbers = baseballNumbers;
	}
	
	public BaseballRoundResult play(
			NumberProvider numberProvider,
			RoundResultConsumer roundResultConsumer
	) {
		BaseballRoundResult baseballRoundResult;
		do {
			baseballRoundResult = playOneRound(numberProvider);
			roundResultConsumer.consume(baseballRoundResult);
		} while (shouldContinuePlay(baseballRoundResult));
		return baseballRoundResult;
	}
	
	private BaseballRoundResult playOneRound(NumberProvider numberProvider) {
		List<Integer> numbers = numberProvider.provide();
		BaseballNumbers tryBaseballNumbers = BaseballNumbers.from(numbers);
		return baseballNumbers.getRoundResult(tryBaseballNumbers);
	}
	
	private static boolean shouldContinuePlay(BaseballRoundResult baseballRoundResult) {
		return !BaseballNumbers.isAllStrike(baseballRoundResult.strikeCount());
	}
}
