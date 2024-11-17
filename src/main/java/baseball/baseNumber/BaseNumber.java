package baseball.baseNumber;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BaseNumber {
    List<Integer> numbers;

    public BaseNumber(List<Integer> numbers) {
        this.numbers = new ArrayList<>(numbers);
    }

    public static BaseNumber create() {
        Set<Integer> distinctNumbers = new HashSet<>();
        while(distinctNumbers.size() < 3) {
            int randomNumber = Randoms.pickNumberInRange(1, 9);
            if (!distinctNumbers.contains(randomNumber)) {
                distinctNumbers.add(randomNumber);
            }
        }
        return new BaseNumber(distinctNumbers.stream().toList());
    }
}
