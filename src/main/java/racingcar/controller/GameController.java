package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameData;
import racingcar.service.GameService;
import racingcar.util.StandardRandomUtils;
import racingcar.view.InputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final GameService service = new GameService();

    public void run() {
        String carNameInput = InputView.getCarName();
        service.validateCarNameInput(carNameInput);
        List<Car> cars = service.setCars(carNameInput);

        String attemptCountInput = InputView.getAttemptCount();
        service.validateAttemptCount(attemptCountInput);

        List<List<Integer>> history = new ArrayList<>();
        GameData gameData = new GameData(Integer.parseInt(attemptCountInput), cars, history);
        service.calculateGameResult(new StandardRandomUtils(), gameData);
    }
}
