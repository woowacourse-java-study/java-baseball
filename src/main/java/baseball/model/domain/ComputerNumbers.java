package baseball.model.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static baseball.common.constant.Constants.MAX_NUMBER;
import static baseball.common.constant.Constants.MIN_NUMBER;
import static baseball.common.constant.Constants.NUMBERS_SIZE;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

public class ComputerNumbers {
    private final List<Integer> computerNumbers;

    public ComputerNumbers() {
        this.computerNumbers = createRandomNumbers();
    }

    private List<Integer> createRandomNumbers() {
        Set<Integer> randomNumbers = new HashSet<>();
        while (randomNumbers.size() < NUMBERS_SIZE) {
            int randomNumber = pickNumberInRange(MIN_NUMBER, MAX_NUMBER);
            randomNumbers.add(randomNumber);
        }
        return new ArrayList<>(randomNumbers);
    }

    public Result compare(PlayerNumbers player) {
        int strikes = 0;
        int balls = 0;

        List<Integer> playerNumbers = player.getPlayerNumbers();

        for (int i = 0; i < NUMBERS_SIZE; i++) {
            boolean isStrike = computerNumbers.get(i).equals(playerNumbers.get(i));
            boolean isBall = !isStrike&&computerNumbers.contains(playerNumbers.get(i));
            if (isStrike) {
                strikes++;
            }
            if (isBall) {
                balls++;
            }
        }
        return new Result(strikes, balls);
    }
}
