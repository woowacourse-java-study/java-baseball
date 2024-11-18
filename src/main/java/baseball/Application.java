package baseball;

import baseball.config.GameConfig;
import baseball.controller.GameController;

public class Application {
    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig();
        GameController gameController = gameConfig.getGameComputer();

        gameController.start();
    }
}