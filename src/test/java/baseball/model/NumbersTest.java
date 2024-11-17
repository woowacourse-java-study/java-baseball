package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;
class NumbersTest {

    @Test
    public void 숫자_입력_범위_예외_테스트() throws Exception{
        //given
        List<Integer> input = List.of(1,2,30);

        //then
        assertThrows(IllegalArgumentException.class,() -> new Numbers(input));
    }

    @Test
    public void 숫자_입력_3개_예외_테스트() throws Exception{
        //given
        List<Integer> input = List.of(1,2,3,4);

        //then
        assertThrows(IllegalArgumentException.class,() -> new Numbers(input));
    }

    @Test
    public void 숫자_입력_중복_예외_테스트() throws Exception{
        //given
        List<Integer> input = List.of(1,2,2);

        //then
        assertThrows(IllegalArgumentException.class,() -> new Numbers(input));
    }
}