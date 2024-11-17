package baseball.domain.baseballRound;

import baseball.common.dto.BaseballRoundResult;
import baseball.service.NumberProvider;
import baseball.service.RetryHandler;

public class BaseballRoundRetryProxy implements BaseballRound {
	
	private final BaseballRound baseballRoundTarget;
	private final RetryHandler retryHandler;
	
	public BaseballRoundRetryProxy(BaseballRound baseballRoundTarget, RetryHandler retryHandler) {
		this.baseballRoundTarget = baseballRoundTarget;
		this.retryHandler = retryHandler;
	}
	
	@Override
	public BaseballRoundResult playOneRound(NumberProvider numberProvider) {
		return retryHandler.tryUntilSuccess(() -> baseballRoundTarget.playOneRound(numberProvider));
	}
}
