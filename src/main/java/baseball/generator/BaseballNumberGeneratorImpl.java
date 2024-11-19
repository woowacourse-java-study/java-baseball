package baseball.generator;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class BaseballNumberGeneratorImpl implements BaseballNumberGenerator{
    private static final int BASEBALL_NUMBER_COUNT = 3;
    private static final int MIN_BASEBALL_NUMBER = 1;
    private static final int MAX_BASEBALL_NUMBER = 9;
    @Override
    public List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MIN_BASEBALL_NUMBER, MAX_BASEBALL_NUMBER, BASEBALL_NUMBER_COUNT);
    }

}
