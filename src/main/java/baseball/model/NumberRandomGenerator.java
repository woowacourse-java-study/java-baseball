package baseball.model;

import baseball.constant.GameConstant;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class NumberRandomGenerator {

    public Numbers generate() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 3) {
            int number = Randoms.pickNumberInRange(
                    GameConstant.GAME_RANGE_START.getValue(),
                    GameConstant.GAME_RANGE_END.getValue()
            );
            if(!numbers.contains(number)) {
                numbers.add(number);
            }
        }

        return new Numbers(numbers);
    }
}
