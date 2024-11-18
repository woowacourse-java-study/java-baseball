package baseball.config;

import baseball.controller.GameController;
import baseball.view.InputView;
import baseball.view.OutputView;

public class GameConfig {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final GameController gameController;

    public GameConfig() {
        this.gameController = new GameController(inputView, outputView);
    }

    public GameController getGameComputer() {
        return gameController;
    }
}
