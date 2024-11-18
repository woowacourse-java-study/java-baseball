package baseball.model.domain;

import java.util.ArrayList;
import java.util.List;

public class GameNumbers {
    private final List<GameNumber> gameNumbers;

    public GameNumbers(String input) {
        this.gameNumbers = generateGameNumbers(input);
    }

    private List<GameNumber> generateGameNumbers(String input) {
        List<GameNumber> gameNumbers = new ArrayList<>();
        return gameNumbers;
    }
}
