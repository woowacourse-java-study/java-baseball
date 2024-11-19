package baseball.model;

import baseball.utils.ErrorMessages;

import java.util.List;

public class Baseball {
    private final List<Integer> numbers;

    public Baseball(List<Integer> numbers) {
        validateRange(numbers);
        validateNumberRange(numbers);
        this.numbers = numbers;
    }
    private void validateRange(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_COUNT);
        }
    }
    private void validateNumberRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1 || num > 9)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE);
        }
    }
    public List<Integer> getNumbers() {
        return numbers;
    }
}
