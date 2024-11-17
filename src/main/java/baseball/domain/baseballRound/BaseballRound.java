package baseball.domain.baseballRound;

import baseball.domain.BaseballRoundResult;
import baseball.service.NumberProvider;

public interface BaseballRound {
	
	BaseballRoundResult playOneRound(NumberProvider numberProvider);
}
