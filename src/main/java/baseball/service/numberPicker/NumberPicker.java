package baseball.service.numberPicker;

@FunctionalInterface
public interface NumberPicker {
	
	int pickNumberInRange(int startInclusive, int endInclusive);
}
