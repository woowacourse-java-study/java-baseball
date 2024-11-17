package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Inputview {

    public String promptUserInput(String message) {
        writeLine(message);
        return readLine();
    }

    private void writeLine(String message) {
        System.out.println(message);
    }

}
