package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberRandomGeneratorTest {

    @Test
    public void 야구게임_숫자_랜덤_생성() throws Exception{
        //given
        NumberRandomGenerator numberRandomGenerator = new NumberRandomGenerator();
        //when
        Numbers numbers = numberRandomGenerator.generate();

        //then
        assertEquals(numbers.getNumbers().size(),3);

    }

}