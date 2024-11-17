package baseball.domain;

import baseball.common.validator.ParamsValidator;
import baseball.domain.baseballRound.BaseballRound;
import baseball.service.NumberProvider;
import baseball.service.RoundResultConsumer;

public class BaseballGame {
	
	private final BaseballRound baseballRound;
	
	public BaseballGame(BaseballRound baseballRound) {
		ParamsValidator.validateParamsNotNull(baseballRound);
		this.baseballRound = baseballRound;
	}
	
	public BaseballRoundResult play(
			NumberProvider numberProvider,
			RoundResultConsumer roundResultConsumer
	) {
		BaseballRoundResult baseballRoundResult;
		do {
			baseballRoundResult = baseballRound.playOneRound(numberProvider);
			roundResultConsumer.consume(baseballRoundResult);
		} while (shouldContinueMoreRound(baseballRoundResult));
		return baseballRoundResult;
	}
	
	private static boolean shouldContinueMoreRound(BaseballRoundResult baseballRoundResult) {
		return !BaseballNumbers.isAllStrike(baseballRoundResult.strikeCount());
	}
}
