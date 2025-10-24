package racingcar.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.GameData;
import racingcar.util.TestRandomUtils;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private final GameService service = new GameService();

    @BeforeAll
    static void setUp() {

    }

    @Test
    void calculateGameResult_Normal_Successful() {
        // given
        int testRandomNumber = 5;
        TestRandomUtils testRandomUtils = new TestRandomUtils(testRandomNumber);
        int attemptCount = 5;
        List<Car> cars = List.of(
                new Car(0, "pobi"),
                new Car(1, "woni"),
                new Car(2, "jun")
        );
        List<List<Integer>> expectedHistory = List.of(
                List.of(1, 1, 1),
                List.of(2, 2, 2),
                List.of(3, 3, 3),
                List.of(4, 4, 4),
                List.of(5, 5, 5)
        );
        GameData expected = new GameData(attemptCount, cars, expectedHistory);

        // when
        GameData actual = new GameData(attemptCount, cars, new ArrayList<>());
        service.calculateGameResult(testRandomUtils, actual);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void calculateWinners_SingleWinner_Successful() {
        // given
        int attemptCount = 5;
        List<Car> cars = List.of(
                new Car(0, "pobi", 5),
                new Car(1, "woni", 4),
                new Car(2, "jun", 4)
        );
        List<List<Integer>> history = List.of(
                List.of(1, 0, 1),
                List.of(2, 1, 2),
                List.of(3, 2, 3),
                List.of(4, 3, 4),
                List.of(5, 4, 4)
        );
        GameData gameData = new GameData(attemptCount, cars, history);
        List<Car> expected = List.of(
                new Car(0, "pobi", 5)
        );

        // when
        List<Car> actual = service.calculateWinners(gameData);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void calculateWinners_MultipleWinners_Successful() {
        // given
        int attemptCount = 5;
        List<Car> cars = List.of(
                new Car(0, "pobi", 5),
                new Car(1, "woni", 4),
                new Car(2, "jun", 5)
        );
        List<List<Integer>> history = List.of(
                List.of(1, 0, 1),
                List.of(2, 1, 2),
                List.of(3, 2, 3),
                List.of(4, 3, 4),
                List.of(5, 4, 5)
        );
        GameData gameData = new GameData(attemptCount, cars, history);
        List<Car> expected = List.of(
                new Car(0, "pobi", 5),
                new Car(2, "jun", 5)
        );

        // when
        List<Car> actual = service.calculateWinners(gameData);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}