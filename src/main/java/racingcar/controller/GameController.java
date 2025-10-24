package racingcar.controller;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.User;
import racingcar.service.GameService;
import racingcar.util.StandardRandomUtils;
import racingcar.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private final User user;
    private final GameService service;

    public GameController(User user) {
        this.user = user;
        service = new GameService();
    }

    public void run() {
        Game game = new Game(user.getAttemptCount(), user.getCars(), new ArrayList<>());
        service.calculateGameResult(new StandardRandomUtils(), game);

        List<Car> winners = service.calculateWinners(game);

        OutputView.printGameResult(game);
        OutputView.printWinners(winners);
    }
}
