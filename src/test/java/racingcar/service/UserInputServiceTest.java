package racingcar.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;
import racingcar.model.UserData;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputServiceTest {

    private UserData userData;
    private UserInputService service;

    @BeforeEach
    void setUp() {
        userData = new UserData();
        service = new UserInputService(userData);
    }

    @Test
    void validateCarNameInput_Normal_ExceptionDoesNotThrow() {
        // given
        String input = "pobi,woni,jun";

        // when

        // then
        assertThatCode(() -> service.validateCarNameInput(input))
                .doesNotThrowAnyException();
    }

    @Test
    void setCars_Normal_Successful() {
        // given
        String input = "pobi,woni,jun";
        List<Car> expected = List.of(
                new Car(0, "pobi"),
                new Car(1, "woni"),
                new Car(2, "jun")
        );

        // when
        service.setCars(input);
        List<Car> actual = userData.getCars();

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validateAttemptCount_Normal_ExceptionDoesNotThrow() {
        // given
        String input = "10";

        // when

        // then
        assertThatCode(() -> service.validateAttemptCount(input))
                .doesNotThrowAnyException();
    }

    @Test
    void validateAttemptCount_WrongInput_ExceptionThrown() {
        // given
        String input = "-20";

        // when

        // then
        assertThrows(IllegalArgumentException.class, () -> service.validateAttemptCount(input));
    }
}
