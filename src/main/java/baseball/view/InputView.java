package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String BASEBALL_GAME_START="숫자 야구 게임을 시작합니다.";
    private static final String INPUT_NUMBER_REQUEST="숫자를 입력해주세요 : ";
    private static final String RESTART_GAME_REQUEST="게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";

    public void printBaseballGameStart() {
        System.out.println(BASEBALL_GAME_START);
    }
    public String inputBasebalNumber() {
        System.out.printf(INPUT_NUMBER_REQUEST);
        return Console.readLine().trim();
    }
    public String restartGame(){
        System.out.println(RESTART_GAME_REQUEST);
        return Console.readLine().trim();
    }
}
