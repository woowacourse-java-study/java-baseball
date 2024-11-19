package baseball.utils;

public class ErrorMessages {
    private static final String ERROR_PREFIX = "[ERROR] ";
    public static final String INVALID_NUMBER_FORMAT = ERROR_PREFIX + "숫자만 입력가능 합니다";
    public static final String INVALID_NUMBER_RANGE = ERROR_PREFIX + "1~9 사이의 숫자만 입력가능합니다";
    public static final String INVALID_CHOICE_RANGE = ERROR_PREFIX + "1또는2만 입력가능합니다";
    public static final String INVALID_INPUT_COUNT = ERROR_PREFIX + "3자리 숫자여야 합니다";

    private ErrorMessages() {
    }
}
