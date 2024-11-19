package baseball.model.domain;

import static baseball.common.constant.Constants.BALL;
import static baseball.common.constant.Constants.NOTHING;
import static baseball.common.constant.Constants.STRIKE;
import static baseball.common.constant.Constants.WHITE_SPACE;

public class Result {
    private final int strikes;
    private final int balls;

    public Result(int strikes, int balls) {
        this.strikes = strikes;
        this.balls = balls;
    }

    public boolean isCorrect() {
        return strikes == 3;
    }

    @Override
    public String toString() {
        if (strikes == 0 && balls == 0) {
            return NOTHING;
        }
        StringBuilder result = new StringBuilder();
        if (balls > 0) {
            result.append(BALL.formatted(balls)).append(WHITE_SPACE);
        }
        if (strikes > 0) {
            result.append(STRIKE.formatted(strikes));
        }
        return result.toString().trim();
    }
}
