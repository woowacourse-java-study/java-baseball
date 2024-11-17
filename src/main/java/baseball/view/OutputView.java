package baseball.view;

public class OutputView {

    public void print(String message) {
        writeLine(message);
    }

    private void writeLine(String message) {
        System.out.println(message);
    }
}
