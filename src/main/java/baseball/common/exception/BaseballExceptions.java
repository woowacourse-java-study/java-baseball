package baseball.common.exception;

public enum BaseballExceptions {
	
	ILLEGAL_ARGUMENT(
			"잘못된 입력입니다.",
			IllegalArgumentException.class
	),
	BASEBALL_NUMBER_RANGE_ILLEGAL(
			"잘못된 숫자 범위 입니다.",
			IllegalArgumentException.class
	),
	BASEBALL_NUMBERS_COUNT_ILLEGAL(
			"잘못된 숫자 개수 입니다.",
			IllegalArgumentException.class
	),
	BASEBALL_NUMBERS_DUPLICATED(
			"숫자는 중복될 수 없습니다.",
			IllegalArgumentException.class
	),
	;
	
	private final String message;
	private final Class<? extends RuntimeException> exceptionType;
	
	BaseballExceptions(String message, Class<? extends RuntimeException> exceptionType) {
		this.message = message;
		this.exceptionType = exceptionType;
	}
	
	public RuntimeException get() {
		try {
			return exceptionType.getDeclaredConstructor(String.class).newInstance(message);
		} catch (Exception e) {
			return new RuntimeException(message);
		}
	}
}
