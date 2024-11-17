package baseball.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Inputview {

    public String promptUserInput(String message) {
        writeSentence(message);
        return readLine();
    }

    private void writeSentence(String message) {
        System.out.print(message);
    }

    private void writeLine(String message) {
        System.out.println(message);
    }

}
