package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class User {

    private int attemptCount;
    private List<Car> cars;

    public User() {
        attemptCount = 0;
        cars = new ArrayList<>();
    }

    public User(int attemptCount, List<Car> cars) {
        this.attemptCount = attemptCount;
        this.cars = cars;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public List<Car> getCars() {
        return cars;
    }
}
