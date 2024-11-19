package baseball.service;

import baseball.common.dto.BaseballRoundResult;

@FunctionalInterface
public interface RoundResultConsumer {
	
	void consume(BaseballRoundResult baseballRoundResult);
}
