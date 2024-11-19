package baseball.config.service.numberPicker;

import baseball.service.numberPicker.MissionUtilsNumberPicker;
import baseball.service.numberPicker.NumberPicker;

public class DefaultNumberPickerConfig implements NumberPickerConfig {
	
	private final NumberPicker numberPicker;
	
	public DefaultNumberPickerConfig() {
		this.numberPicker = new MissionUtilsNumberPicker();
	}
	
	@Override
	public NumberPicker getNumberPicker() {
		return numberPicker;
	}
}
