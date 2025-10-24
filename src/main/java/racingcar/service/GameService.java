package racingcar.service;

import racingcar.model.Car;
import racingcar.model.GameData;
import racingcar.parser.CarNameParser;
import racingcar.util.RandomUtils;
import racingcar.validator.AttemptCountValidator;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GameService {

    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final AttemptCountValidator attemptCountValidator = new AttemptCountValidator();
    private final CarNameParser carNameParser = new CarNameParser();

    public void validateCarNameInput(String input) {
        boolean isValid = carNameValidator.validate(input);

        if (!isValid) {
            throw new IllegalArgumentException("자동차 이름 입력이 유효하지 않습니다.");
        }
    }

    public List<Car> setCars(String input) {
        List<String> carNames = carNameParser.parse(input);

        return IntStream.range(0, carNames.size())
                .mapToObj(i -> new Car(i, carNames.get(i)))
                .collect(Collectors.toList());
    }

    public void validateAttemptCount(String input) {
        boolean isValid = attemptCountValidator.validate(input);

        if (!isValid) {
            throw new IllegalArgumentException("입력된 시도 횟수가 유효하지 않습니다.");
        }
    }

    public void calculateGameResult(RandomUtils randomUtils, GameData gameData) {
        int attemptCount = gameData.getAttemptCount();
        List<Car> cars = gameData.getCars();

        for (int attempt = 0; attempt < attemptCount; attempt++) {
            List<Integer> roundResult = getRoundResult(randomUtils, cars);
            gameData.updateHistory(roundResult);
        }
    }

    public List<Car> calculateWinners(GameData gameData) {
        List<Car> winners = new ArrayList<>();
        int maxMoveCount = gameData.getHistory()
                .getLast().stream()
                .mapToInt(x -> x)
                .max().orElse(0);

        for (Car car: gameData.getCars()) {
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
