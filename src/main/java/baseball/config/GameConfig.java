package baseball.config;

import baseball.controller.GameComputer;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameConfig {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameComputer gameComputer;

    public GameConfig() {
        this.gameComputer = new GameComputer(inputView, outputView);
    }
}
