package baseball.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String requestGameNumbers() {
        return Console.readLine();
    }

    public String requestGameRetry() {
        return Console.readLine();
    }
}
