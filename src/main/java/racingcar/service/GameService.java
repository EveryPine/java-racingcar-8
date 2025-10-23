package racingcar.service;

import racingcar.model.Car;
import racingcar.parser.CarNameParser;
import racingcar.validator.AttemptCountValidator;
import racingcar.validator.CarNameValidator;

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
}
