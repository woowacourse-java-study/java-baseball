package baseball.common.validator;


import baseball.common.exception.BaseballExceptions;

import java.util.Objects;

public class ParamsValidator {
	
	public static void validateParamsNotNull(final Object... params) {
		for (Object obj : params) {
			if (Objects.isNull(obj)) {
				throw BaseballExceptions.ILLEGAL_ARGUMENT.get();
			}
		}
	}
}
