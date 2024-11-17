package baseball.domain.baseballRound;

import baseball.common.retry.RetryHandler;
import baseball.domain.BaseballRoundResult;
import baseball.service.NumberProvider;

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
