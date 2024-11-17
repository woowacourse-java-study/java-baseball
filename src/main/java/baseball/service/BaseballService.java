package baseball.service;

import baseball.domain.BaseballGame;
import baseball.domain.BaseballNumbers;
import baseball.domain.BaseballRound;
import baseball.service.numberPicker.NumberPicker;

public class BaseballService {
	
	private final NumberPicker numberPicker;
	
	public BaseballService(NumberPicker numberPicker) {
		this.numberPicker = numberPicker;
	}
	
	public BaseballGame createBaseballGame() {
		BaseballNumbers baseballNumbers = BaseballNumbers.from(numberPicker);
		BaseballRound baseballRound = new BaseballRound(baseballNumbers);
		return new BaseballGame(baseballRound);
	}
}
