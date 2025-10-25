package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AttemptCountValidatorTest {

    private final AttemptCountValidator attemptCountValidator = new AttemptCountValidator();

    @Test
    void validate_Normal_True() {
        // given
        String input = "5";
        ValidationResult expected = ValidationResult.success();

        // when
        ValidationResult actual = attemptCountValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_WrongFormatInput_False() {
        // given
        String input = "5#";
        ValidationResult expected = ValidationResult.failure(ErrorCode.ATTEMPTCOUNT_INVALID_FORMAT);

        // when
        ValidationResult actual = attemptCountValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_LessThanMinAttemptCount_False() {
        // given
        String input = "-1";
        ValidationResult expected = ValidationResult.failure(ErrorCode.ATTEMPTCOUNT_INVALID_COUNT);

        // when
        ValidationResult actual = attemptCountValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_GreaterThanMaxAttemptCount_False() {
        // given
        String input = "200";
        ValidationResult expected = ValidationResult.failure(ErrorCode.ATTEMPTCOUNT_INVALID_COUNT);

        // when
        ValidationResult actual = attemptCountValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}