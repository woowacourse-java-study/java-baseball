package baseball.dto;

public class ResultDTO {
    private final int strikes;
    private final int balls;

    public ResultDTO(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }
}
