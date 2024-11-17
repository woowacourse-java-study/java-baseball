package baseball.model;

import static org.junit.jupiter.api.Assertions.*;

import baseball.dto.MatchDto;
import org.junit.jupiter.api.Test;

class RefereeTest {
    @Test
    public void 스트라이크가_3이면_참() throws Exception {
        //given
        MatchDto matchDto = new MatchDto(3, 0);
        Referee referee = new Referee();

        //when
        boolean result =  referee.win(matchDto);

        //then
        assertTrue(result);
    }

    @Test
    public void 스트라이크가_3이_아니면_거짓() throws Exception {
        //given
        MatchDto matchDto = new MatchDto(2, 0);
        Referee referee = new Referee();

        //when
        boolean result =  referee.win(matchDto);

        //then
        assertFalse(result);
    }

}