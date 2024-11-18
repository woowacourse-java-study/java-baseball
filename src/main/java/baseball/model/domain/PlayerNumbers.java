package baseball.model.domain;

import java.util.ArrayList;
import java.util.List;

public class PlayerNumbers {
    private final List<Integer> playerNumbers;

    public PlayerNumbers(String input) {
        this.playerNumbers = parse(input);
    }

    private List<Integer> parse(String input) {
        List<String> items = List.of(input.split(""));
        List<Integer> numbers = new ArrayList<>();
        for (String item : items) {
            int number = parseNumber(item);
            numbers.add(number);
        }
        validateNumbers(numbers);
        return numbers;
    }

    private int parseNumber(String input) {
        try {
            int number = Integer.parseInt(input);
            validateNumber(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }

    private int validateNumber(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("숫자는 1에서 9까지의 수만 허용됩니다.");
        }
        return number;
    }

    private void validateNumbers(List<Integer> numbers) {
        if (numbers.size() != 3) {
            throw new IllegalArgumentException("숫자 3자리를 입력해야 합니다.");
        }
        int uniqueCount = (int) numbers.stream()
                .distinct()
                .count();
        if (uniqueCount != 3) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }

    public List<Integer> getPlayerNumbers() {
        return playerNumbers;
    }
}
