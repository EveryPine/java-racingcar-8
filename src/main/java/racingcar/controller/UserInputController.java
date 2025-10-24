package racingcar.controller;

import racingcar.model.User;
import racingcar.service.UserInputService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class UserInputController {

    private final UserInputService service;

    public UserInputController(User user) {
        this.service = new UserInputService(user);
    }

    public void run() {
        OutputView.printCarNameInputMessage();
        String carNameInput = InputView.getInput();
        service.validateCarNameInput(carNameInput);
        service.setCars(carNameInput);

        OutputView.printAttemptCountInputMessage();
        String attemptCountInput = InputView.getInput();
        service.validateAttemptCount(attemptCountInput);
        service.setAttemptCount(attemptCountInput);
    }
}
