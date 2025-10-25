package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private User user;
    private List<List<Integer>> history;
    private List<Car> winners;

    public Game(User user, List<List<Integer>> history) {
        this.user = user;
        this.history = history;
        this.winners = new ArrayList<>();
    }

    public void setWinners(List<Car> winners) {
        this.winners = winners;
    }

    public User getUser() {
        return user;
    }

    public List<List<Integer>> getHistory() {
        return history;
    }

    public List<Car> getWinners() {
        return winners;
    }

    public void updateHistory(List<Integer> roundResult) {
        history.add(roundResult);
    }

}
