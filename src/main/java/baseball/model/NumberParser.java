package baseball.model;

import java.util.ArrayList;
import java.util.List;

public class NumberParser {
    public Numbers parse(String inputString) {
        validate(inputString);
        List<String> inputStringList = List.of(inputString.trim().split(""));
        List<Integer> inputIntegerList = new ArrayList<>();
        for (String stringElement : inputStringList) {
            inputIntegerList.add(Integer.parseInt(stringElement));
        }
        return new Numbers(inputIntegerList);
    }

    private void validate(String inputString) {
        nullValidator(inputString);
        numericValidator(inputString);

    }

    private static void nullValidator(String inputString) {
        if (inputString == null || inputString.isBlank()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
    }

    private static void numericValidator(String inputString) {
        try {
            List<String> inputStringList = List.of(inputString.trim().split(""));
            for (String stringElement : inputStringList) {
                Integer.parseInt(stringElement);
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력하지 않았습니다.");
        }
    }
}
