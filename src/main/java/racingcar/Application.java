package racingcar;

import racingcar.controller.GameController;
import racingcar.controller.UserInputController;
import racingcar.model.User;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        User user = new User();
        UserInputController userInputController = new UserInputController(user);
        userInputController.run();

        GameController gameController = new GameController(user);
        gameController.run();
    }
}
