package baseball.model.domain;

public class GameNumber {
    private final int number;

    public GameNumber(int number) {
        this.number = validate(number);
    }

    private int validate(int number) {
        if (number < 1 || number > 9) {
            throw new IllegalArgumentException("숫자는 1에서 9까지 수만 허용 됩니다.");
        }
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
