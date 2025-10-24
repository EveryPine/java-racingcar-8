package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.UserInputController;
import racingcar.model.GameData;
import racingcar.model.UserData;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        UserData userData = new UserData();
        UserInputController userInputController = new UserInputController(userData);
        userInputController.run();

        GameController gameController = new GameController(userData);
        gameController.run();
    }
}
