package baseball.utils;

public class ErrorMessages {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INVALID_NUMBER_FORMAT = ERROR_PREFIX + "숫자만 입력가능 합니다";
    public static final String INVALID_NUMBER_RANGE = ERROR_PREFIX + "1~9사이의 숫자만 입력가능합니다";

    private ErrorMessages() {
    }
}
