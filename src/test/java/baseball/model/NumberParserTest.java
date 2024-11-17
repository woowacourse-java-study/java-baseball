package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberParserTest {
    NumberParser numberParser = new NumberParser();
    @Test
    public void 숫자_입력_빈값_예외_테스트() throws Exception {
        //given
        String input = "";

        //then
        assertThrows(IllegalArgumentException.class,() -> numberParser.parse(input));
    }

    @Test
    public void 숫자_입력_문자_예외_테스트() throws Exception {
        //given
        String input = "12p";

        //then
        assertThrows(IllegalArgumentException.class,() -> numberParser.parse(input));
    }
}