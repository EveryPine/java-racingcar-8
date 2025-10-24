package racingcar.model;

import java.util.List;

public class Game {

    private int attemptCount;
    private List<Car> cars;
    private List<List<Integer>> history;

    public Game(int attemptCount, List<Car> cars, List<List<Integer>> history) {
        this.attemptCount = attemptCount;
        this.cars = cars;
        this.history = history;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public List<Car> getCars() {
        return cars;
    }

    public List<List<Integer>> getHistory() {
        return history;
    }

    public void updateHistory(List<Integer> roundResult) {
        history.add(roundResult);
    }

}
