package baseball.guessResult;

public class GuessResult {
    private final int strike;
    private final int ball;

    public GuessResult(int strike, int ball) {
        this.strike = strike;
        this.ball = ball;
    }

    public static GuessResult from(int strike, int ball) {
        return new GuessResult(strike, ball);
    }
}
