package baseball.model.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class GameNumbers {
    private final List<GameNumber> gameNumbers;

    public GameNumbers(String input) {
        this.gameNumbers = parse(input);
    }

    public GameNumbers(Set<Integer> randomNumbers) {
        this.gameNumbers = parse(randomNumbers);
    }

    private List<GameNumber> parse(String input) {
        List<String> items = List.of(input.split(""));
        List<GameNumber> gameNumbers = new ArrayList<>();
        for (String item : items) {
            GameNumber gameNumber = new GameNumber(item);
            gameNumbers.add(gameNumber);
        }
        validate(gameNumbers);
        return gameNumbers;
    }

    private List<GameNumber> parse(Set<Integer> randomNumbers) {
        List<GameNumber> gameNumbers = new ArrayList<>();
        for (int number : randomNumbers) {
            GameNumber gameNumber = new GameNumber(number);
            gameNumbers.add(gameNumber);
        }
        validate(gameNumbers);
        return gameNumbers;
    }

    private void validate(List<GameNumber> gameNumbers) {
        if (gameNumbers.size() != 3) {
            throw new IllegalArgumentException("숫자 3자리를 입력해야 합니다.");
        }
        int uniqueCount = gameNumbers.stream()
                .map(GameNumber::getNumber)
                .collect(Collectors.toSet())
                .size();
        if (uniqueCount != 3) {
            throw new IllegalArgumentException("중복된 숫자는 허용되지 않습니다.");
        }
    }
}
