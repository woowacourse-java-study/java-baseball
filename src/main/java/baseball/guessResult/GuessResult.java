package baseball.guessResult;

import baseball.game.controller.constant.Rules;

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

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        if (nothing(stringBuilder)){
            return stringBuilder.toString();
        }
        appendBall(stringBuilder);
        appendStrike(stringBuilder);
        return stringBuilder.toString();
    }

    private boolean nothing(StringBuilder stringBuilder) {
        if (ball + strike == 0) {
            stringBuilder.append("낫싱");
            return true;
        }
        return false;
    }

    private void appendBall(StringBuilder stringBuilder) {
        if (ball > 0) {
            stringBuilder.append(ball);
            stringBuilder.append("볼");
            stringBuilder.append(" ");
        }
    }

    private void appendStrike(StringBuilder stringBuilder) {
        if (strike > 0) {
            stringBuilder.append(strike);
            stringBuilder.append("스트라이크");
        }
    }

    public boolean fullStrike() {
        return strike == Rules.BASE_NUMBER_COUNT;
    }
}
