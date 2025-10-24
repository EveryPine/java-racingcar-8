package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.GameData;
import racingcar.model.UserData;
import racingcar.service.GameService;
import racingcar.util.StandardRandomUtils;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final UserData userData;
    private final GameService service;

    public GameController(UserData userData) {
        this.userData = userData;
        service = new GameService();
    }

    public void run() {
        GameData gameData = new GameData(userData.getAttemptCount(), userData.getCars(), new ArrayList<>());
        service.calculateGameResult(new StandardRandomUtils(), gameData);

        List<Car> winners = service.calculateWinners(gameData);

        OutputView.printGameResult(gameData);
        OutputView.printWinners(winners);
    }
}
