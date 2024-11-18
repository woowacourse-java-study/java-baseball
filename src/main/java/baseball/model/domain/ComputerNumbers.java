package baseball.model.domain;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.HashSet;
import java.util.Set;

public class ComputerNumbers {
    private final GameNumbers computerNumbers;

    public ComputerNumbers() {
        this.computerNumbers = createComputerNumbers();
    }

    public static GameNumbers createComputerNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < 3) {
            int randomNumber = pickNumberInRange(1, 9);
            randomNumbers.add(randomNumber);
        }
        return new GameNumbers(randomNumbers);
    }
}
