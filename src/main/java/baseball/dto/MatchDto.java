package baseball.dto;

public class MatchDto {
    private final Integer strike;
    private final Integer ball;

    public MatchDto(Integer strike, Integer ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public Integer getStrike() {
        return strike;
    }

    public Integer getBall() {
        return ball;
    }
}
