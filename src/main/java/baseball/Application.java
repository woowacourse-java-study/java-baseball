package baseball;

import baseball.config.GameConfig;
import baseball.controller.GameComputer;

public class Application {
    public static void main(String[] args) {
        GameConfig gameConfig = new GameConfig();
        GameComputer gameComputer = gameConfig.getGameComputer();

        gameComputer.start();
    }
}