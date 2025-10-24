package racingcar.service;

import racingcar.model.Car;
import racingcar.model.Game;
import racingcar.util.RandomUtils;

import java.util.ArrayList;
import java.util.List;

public class GameService {

    public void calculateGameResult(RandomUtils randomUtils, Game game) {
        int attemptCount = game.getAttemptCount();
        List<Car> cars = game.getCars();

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            List<Integer> roundResult = getRoundResult(randomUtils, cars);
            game.updateHistory(roundResult);
        }
    }

    public List<Car> calculateWinners(Game game) {
        List<Car> winners = new ArrayList<>();
        int maxMoveCount = game.getHistory()
                .getLast().stream()
                .mapToInt(x -> x)
                .max().orElse(0);

        for (Car car: game.getCars()) {
            if (car.getPosition() == maxMoveCount) {
                winners.add(car);
            }
        }

        return winners;
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
