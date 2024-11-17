package baseball.service.numberPicker;

import camp.nextstep.edu.missionutils.Randoms;

public class MissionUtilsNumberPicker implements NumberPicker {
	
	@Override
	public int pickNumberInRange(int startInclusive, int endInclusive) {
		return Randoms.pickNumberInRange(startInclusive, endInclusive);
	}
}
