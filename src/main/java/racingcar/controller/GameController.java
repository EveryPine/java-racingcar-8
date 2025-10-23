package racingcar.controller;

import racingcar.model.Car;
import racingcar.service.GameService;
import racingcar.view.InputView;

import java.util.List;

public class GameController {

    private final GameService service = new GameService();

    public void run() {
        String carNameInput = InputView.getCarName();
        service.validateCarNameInput(carNameInput);
        List<Car> cars = service.setCars(carNameInput);

    }
}
