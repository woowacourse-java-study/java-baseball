package baseball.service.baseballGameFactory;

import baseball.common.retry.RetryHandler;
import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.domain.baseballRound.BaseballRound;
import baseball.domain.baseballRound.BaseballRoundRetryProxy;
import baseball.domain.baseballRound.DefaultBaseballRound;
import baseball.service.numberPicker.NumberPicker;

public class DefaultBaseballGameFactory implements BaseballGameFactory {
	
	private final NumberPicker numberPicker;
	private final RetryHandler retryHandler;
	
	public DefaultBaseballGameFactory(NumberPicker numberPicker, RetryHandler retryHandler) {
		this.numberPicker = numberPicker;
		this.retryHandler = retryHandler;
	}
	
	@Override
	public BaseballGame create() {
		BaseballNumbers baseballNumbers = BaseballNumbers.from(numberPicker);
		BaseballRound baseballRound = createBaseballRound(baseballNumbers);
		return new BaseballGame(baseballRound);
	}
	
	private BaseballRound createBaseballRound(BaseballNumbers baseballNumbers) {
		DefaultBaseballRound defaultBaseballRound = new DefaultBaseballRound(baseballNumbers);
		return new BaseballRoundRetryProxy(defaultBaseballRound, retryHandler);
	}
}
