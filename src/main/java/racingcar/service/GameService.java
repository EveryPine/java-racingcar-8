package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.model.User;
import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public void calculateGameResult(RandomUtils randomUtils, Game game) {
        User user = game.getUser();
        int attemptCount = user.getAttemptCount();
        List<Car> cars = user.getCars();

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            List<Integer> roundResult = getRoundResult(randomUtils, cars);
            game.updateHistory(roundResult);
        }
    }

    public void calculateWinners(Game game) {
        List<Car> cars = game.getUser().getCars();
        List<Integer> gameResult = game.getHistory().getLast();

        // 게임 결과에서 최대 이동 횟수를 가진 자동차만 선별
        int maxMoveCount = gameResult.stream()
                .mapToInt(moveCount -> moveCount)
                .max().orElse(0);
        List<Car> winners = cars.stream()
                .filter(car -> car.getPosition() == maxMoveCount)
                .toList();

        game.setWinners(winners);
    }

    private List<Integer> getRoundResult(RandomUtils randomUtils, List<Car> cars) {
        List<Integer> roundResult = new ArrayList<>();

        for (int carIndex = 0; carIndex < cars.size(); carIndex++) {
            Car car = cars.get(carIndex);
            car.move(randomUtils.getRandomInteger());
            roundResult.add(car.getPosition());
        }

        return roundResult;
    }
}
