package baseball;

import baseball.config.Appconfig;
import baseball.controller.BaseballController;

public class Application {
    public static void main(String[] args) {
        Appconfig appConfig = new Appconfig();
        BaseballController baseballController = appConfig.baseballController();
        baseballController.start();
    }
}
