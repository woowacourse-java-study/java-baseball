package baseball.model.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerNumbers {
    private final GameNumbers computerNumbers;

    public ComputerNumbers() {
        this.computerNumbers = createRandomNumbers();
    }

    public static GameNumbers createRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }
        return new GameNumbers(randomNumbers);
    }
}
