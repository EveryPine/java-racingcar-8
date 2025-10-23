package racingcar.model;

import java.util.List;

public class GameState {

    private int attemptCount;
    private List<Car> cars;

    public GameState(int attemptCount, List<Car> cars) {
        this.attemptCount = attemptCount;
        this.cars = cars;
    }


}
