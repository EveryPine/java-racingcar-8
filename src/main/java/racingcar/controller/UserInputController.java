package racingcar.controller;

import racingcar.model.UserData;
import racingcar.service.UserInputService;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class UserInputController {

    private final UserInputService service;

    public UserInputController(UserData userData) {
        this.service = new UserInputService(userData);
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
