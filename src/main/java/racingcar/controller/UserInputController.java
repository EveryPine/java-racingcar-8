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
        // TODO 1: 경주할 자동차 이름을 입력받는다
        OutputView.printCarNameInputMessage();
        String carNameInput = InputView.getInput();
        service.validateCarNameInput(carNameInput);
        service.setCars(carNameInput);

        // TODO 2: 시도 횟수를 입력받는다
        OutputView.printAttemptCountInputMessage();
        String attemptCountInput = InputView.getInput();
        service.validateAttemptCount(attemptCountInput);
        service.setAttemptCount(attemptCountInput);
    }
}
