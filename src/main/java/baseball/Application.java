package baseball;

import baseball.game.controller.GameController;
import baseball.view.Inputview;
import baseball.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        Inputview inputview = new Inputview();
        GameController gameController = new GameController(outputView, inputview);
        gameController.play();
    }
}
