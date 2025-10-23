package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AttemptCountValidatorTest {

    private final AttemptCountValidator attemptCountValidator = new AttemptCountValidator();

    @Test
    void validate_Normal_True() {
        // given
        String input = "5";
        boolean expected = true;

        // when
        boolean actual = attemptCountValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_WrongFormatInput_False() {
        // given
        String input = "5#";
        boolean expected = false;

        // when
        boolean actual = attemptCountValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_LessThanMinAttemptCount_False() {
        // given
        String input = "-1";
        boolean expected = false;

        // when
        boolean actual = attemptCountValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_GreaterThanMaxAttemptCount_False() {
        // given
        String input = "200";
        boolean expected = false;

        // when
        boolean actual = attemptCountValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }
}