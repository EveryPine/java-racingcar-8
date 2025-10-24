package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameData;
import racingcar.service.GameService;
import racingcar.util.StandardRandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final GameService service = new GameService();

    public void run() {
        OutputView.printCarNameInputMessage();
        String carNameInput = InputView.getInput();
        service.validateCarNameInput(carNameInput);
        List<Car> cars = service.setCars(carNameInput);

        OutputView.printAttemptCountInputMessage();
        String attemptCountInput = InputView.getInput();
        service.validateAttemptCount(attemptCountInput);

        List<List<Integer>> history = new ArrayList<>();
        GameData gameData = new GameData(Integer.parseInt(attemptCountInput), cars, history);
        service.calculateGameResult(new StandardRandomUtils(), gameData);

        List<Car> winners = service.calculateWinners(gameData);

        OutputView.printGameResult(gameData);
        OutputView.printWinners(winners);
    }
}
