package racingcar.controller;

import racingcar.model.Game;
import racingcar.model.User;
import racingcar.service.GameService;
import racingcar.util.StandardRandomUtils;
import racingcar.view.OutputView;

import java.util.ArrayList;

public class GameController {

    private final User user;
    private final GameService service;

    public GameController(User user) {
        this.user = user;
        service = new GameService();
    }

    public void run() {
        Game game = new Game(user, new ArrayList<>());
        service.calculateGameResult(new StandardRandomUtils(), game);
        service.calculateWinners(game);

        OutputView.printGameResult(game);
        OutputView.printWinners(game.getWinners());
    }
}
