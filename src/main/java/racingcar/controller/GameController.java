package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameState;
import racingcar.service.GameService;
import racingcar.view.InputView;

import java.util.List;

public class GameController {

    private final GameService service = new GameService();

    public void run() {
        String carNameInput = InputView.getCarName();
        service.validateCarNameInput(carNameInput);
        List<Car> cars = service.setCars(carNameInput);

        String attemptCountInput = InputView.getAttemptCount();
        service.validateAttemptCount(attemptCountInput);
        GameState gameState = new GameState(Integer.parseInt(attemptCountInput), cars);

    }
}
