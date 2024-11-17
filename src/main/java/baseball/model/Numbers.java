package baseball.model;

import baseball.constant.GameConstant;
import baseball.dto.MatchDto;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Numbers {
    private final List<Integer> numbers;
    private final int gameValue = GameConstant.GAME_SIZE.getValue();
    private final int gameRangeStart = GameConstant.GAME_RANGE_START.getValue();
    private final int gameRangeEnd = GameConstant.GAME_RANGE_END.getValue();

    public Numbers(List<Integer> inputNumbers) {
        validate(inputNumbers);
        numbers = inputNumbers;
    }

    public MatchDto match(Numbers otherNumbers) {
        int strike = 0;
        int ball = 0;
        for (int i = 0; i < gameValue; i++) {
            if (numbers.indexOf(otherNumbers.getNumbers().get(i)) == i) {
                strike++;
                continue;
            }
            if (numbers.contains(otherNumbers.numbers.get(i))) {
                ball++;
            }
        }
        return new MatchDto(strike, ball);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validate(List<Integer> inputNumbers) {
        sizeValidator(inputNumbers);
        rangeValidator(inputNumbers);
        duplicateValidator(inputNumbers);
    }

    private void sizeValidator(List<Integer> inputNumbers) {
        if (inputNumbers.size() != gameValue) {
            throw new IllegalArgumentException("숫자 3개를 입력하지 않았습니다.");
        }
    }

    private void rangeValidator(List<Integer> inputNumbers) {
        for (Integer inputNumber : inputNumbers) {
            if (inputNumber < gameRangeStart || inputNumber > gameRangeEnd) {
                throw new IllegalArgumentException("숫자를 범위에 맞게 입력하지 않았습니다.");
            }
        }
    }

    private static void duplicateValidator(List<Integer> inputNumbers) {
        Set<Integer> numbersSet = new HashSet<>(inputNumbers);
        if (numbersSet.size() != inputNumbers.size()) {
            throw new IllegalArgumentException("중복된 숫자를 입력하였습니다.");
        }
    }
}
