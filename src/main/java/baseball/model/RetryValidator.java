package baseball.model;

public class RetryValidator {

    public void validateInputRetry(String inputRetryString) {
        if (inputRetryString == null || inputRetryString.isBlank()) {
            throw new IllegalArgumentException("아무것도 입력하지 않았습니다.");
        }
        if (!inputRetryString.trim().equals("1") && !inputRetryString.trim().equals("2")) {
            throw new IllegalArgumentException("1과 2중 하나를 입력해야 합니다.");
        }
    }
}
