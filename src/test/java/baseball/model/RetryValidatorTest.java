package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RetryValidatorTest {

    RetryValidator retryValidator = new RetryValidator();

    @Test
    public void 재시도_입력_빈값_예외_테스트() throws Exception{
        //given
        String input = "";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            retryValidator.validateInputRetry(input);
        });
    }
    @Test
    public void 재시도_입력_1과2_선택_예외_테스트() throws Exception{
        //given
        String input = "3";

        //then
        assertThrows(IllegalArgumentException.class, () -> {
            retryValidator.validateInputRetry(input);
        });
    }
}