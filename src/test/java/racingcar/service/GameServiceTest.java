package racingcar.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.*;

class GameServiceTest {

    private final GameService gameService = new GameService();

    @BeforeAll
    static void setUp() {

    }

    @Test
    void validateCarNameInput() {
        // given
        String input = "pobi,woni,jun";

        // when

        // then
        assertThatCode(() -> gameService.validateCarNameInput(input))
                .doesNotThrowAnyException();
    }

    @Test
    void setCars() {
        // given
        String input = "pobi,woni,jun";
        List<Car> expected = List.of(
                new Car(0, "pobi"),
                new Car(1, "woni"),
                new Car(2, "jun")
        );

        // when
        List<Car> actual = gameService.setCars(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validateAttemptCount_Normal_ExceptionDoesNotThrown() {
        // given
        String input = "10";

        // when

        // then
        assertThatCode(() -> gameService.validateAttemptCount(input))
                .doesNotThrowAnyException();
    }

    @Test
    void validateAttemptCount_WrongInput_ExceptionThrown() {
        // given
        String input = "-20";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> gameService.validateAttemptCount(input));
    }
}