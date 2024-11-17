package baseball.domain.baseballRound;

import baseball.common.dto.BaseballRoundResult;
import baseball.service.NumberProvider;

public interface BaseballRound {
	
	BaseballRoundResult playOneRound(NumberProvider numberProvider);
}
