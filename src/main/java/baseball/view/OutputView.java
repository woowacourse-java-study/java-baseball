package baseball.view;

import baseball.dto.ResultDTO;

public class OutputView {

    // 상수 선언
    private static final String NOTHING_MESSAGE = "낫싱";
    private static final String STRIKE_MESSAGE_FORMAT = "%d스트라이크";
    private static final String BALL_MESSAGE_FORMAT = "%d볼 ";
    private static final String GAME_OVER_MESSAGE = "게임 종료";
    private static final int MAX_STRIKES = 3;

    public void printResult(ResultDTO result) {
        int strikes = result.getStrikes();
        int balls = result.getBalls();

        // 출력 로직만 처리
        if (strikes == 0 && balls == 0) {
            System.out.println(NOTHING_MESSAGE);
        }

        if (strikes == MAX_STRIKES) {
            System.out.println(String.format(STRIKE_MESSAGE_FORMAT, strikes));
            System.out.println(GAME_OVER_MESSAGE);
        }

        if (strikes > 0 || balls > 0) {
            StringBuilder resultMessage = new StringBuilder();
            if (balls > 0) {
                resultMessage.append(String.format(BALL_MESSAGE_FORMAT, balls));
            }
            if (strikes > 0) {
                resultMessage.append(String.format(STRIKE_MESSAGE_FORMAT, strikes));
            }
            System.out.println(resultMessage.toString().trim());
        }
    }
}
