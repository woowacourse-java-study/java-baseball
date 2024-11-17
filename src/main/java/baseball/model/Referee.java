package baseball.model;

import baseball.dto.MatchDto;

public class Referee {
    public boolean win(MatchDto matchDto) {
        return matchDto.getStrike().equals(3);
    }
}
