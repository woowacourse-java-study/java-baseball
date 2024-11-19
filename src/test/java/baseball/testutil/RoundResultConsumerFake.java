package baseball.testutil;

import baseball.common.dto.BaseballRoundResult;
import baseball.service.RoundResultConsumer;

import java.util.ArrayList;
import java.util.List;

public class RoundResultConsumerFake implements RoundResultConsumer {
	
	List<BaseballRoundResult> results = new ArrayList<>();
	
	@Override
	public void consume(BaseballRoundResult baseballRoundResult) {
		results.add(baseballRoundResult);
	}
	
	public List<BaseballRoundResult> getResults() {
		return results;
	}
}
