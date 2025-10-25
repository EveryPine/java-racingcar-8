package racingcar.service;

import racingcar.model.Car;
import racingcar.model.User;
import racingcar.parser.CarNameParser;
import racingcar.validator.AttemptCountValidator;
import racingcar.validator.CarNameValidator;
import racingcar.validator.ValidationResult;

import java.util.List;
import java.util.stream.IntStream;

public class UserInputService {

    private final User user;
    private final CarNameValidator carNameValidator = new CarNameValidator();
    private final AttemptCountValidator attemptCountValidator = new AttemptCountValidator();
    private final CarNameParser carNameParser = new CarNameParser();

    public UserInputService(User user) {
        this.user = user;
    }

    public void validateCarNameInput(String input) {
        ValidationResult validationResult = carNameValidator.validate(input);

        if (validationResult.isFailure()) {
            throw new IllegalArgumentException(validationResult.getErrorCode().getMessage());
        }
    }

    public void setCars(String input) {
        List<String> carNames = carNameParser.parse(input);
        int carCount = carNames.size();
        List<Car> cars = IntStream.range(0, carCount)
                .mapToObj(carIndex -> new Car(carIndex, carNames.get(carIndex)))
                .toList();

        user.setCars(cars);
    }

    public void validateAttemptCount(String input) {
        ValidationResult validationResult = attemptCountValidator.validate(input);

        if (validationResult.isFailure()) {
            throw new IllegalArgumentException(validationResult.getErrorCode().getMessage());
        }
    }

    public void setAttemptCount(String input) {
        int attemptCount = Integer.parseInt(input);

        user.setAttemptCount(attemptCount);
    }
}
