package baseball.service;

import baseball.domain.BaseballRoundResult;

@FunctionalInterface
public interface RoundResultConsumer {
	
	void consume(BaseballRoundResult baseballRoundResult);
}
