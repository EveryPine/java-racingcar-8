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
        // TODO 3: 자동차 경주 게임의 결과를 계산한다
        Game game = new Game(user, new ArrayList<>());
        service.calculateGameResult(new StandardRandomUtils(), game);

        // TODO 4: 자동차 경주 게임의 우승자를 계산한다
        service.calculateWinners(game);

        // TODO 5: 게임 결과를 출력한다
        OutputView.printGameResult(game);
        OutputView.printWinners(game.getWinners());
    }
}
