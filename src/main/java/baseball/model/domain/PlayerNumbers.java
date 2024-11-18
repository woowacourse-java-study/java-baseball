package baseball.model.domain;

public class PlayerNumbers {
    private final GameNumbers playerNumbers;

    public PlayerNumbers(String input) {
        this.playerNumbers = new GameNumbers(input);
    }
}
