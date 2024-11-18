package baseball.model.domain;

public class GameNumber {
    private final int number;

    public GameNumber(String input) {
        this.number = parse(input);
    }

    public GameNumber(int number) {
        this.number = number;
    }

    private int parse(String input) {
        try {
            int number = Integer.parseInt(input);
            validate(number);
            return number;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("입력값은 숫자여야 합니다.");
        }
    }

    private int validate(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("숫자는 1에서 9까지의 수만 허용됩니다.");
        }
        return number;
    }

    public int getNumber() {
        return number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        GameNumber number = (GameNumber) o;
        return this.number == number.number;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(number);
    }
}
