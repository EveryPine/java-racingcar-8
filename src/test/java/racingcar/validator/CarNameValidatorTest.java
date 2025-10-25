package racingcar.validator;

import org.junit.jupiter.api.Test;
import racingcar.exception.ErrorCode;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {

    private CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void validate_Normal_True() {
        //given
        String input = "Pobi,woni,jun";
        ValidationResult expected = ValidationResult.success();

        // when
        ValidationResult actual = carNameValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_EmptyInput_False() {
        // given
        String input = "";
        ValidationResult expected = ValidationResult.failure(ErrorCode.COMMON_EMPTY_INPUT);

        // when
        ValidationResult actual = carNameValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_MoreThan50Cars_False() {
        // given
        String input = "asdf" + ",asdf".repeat(50);
        ValidationResult expected = ValidationResult.failure(ErrorCode.CARNAME_INVALID_COUNT);

        // when
        ValidationResult actual = carNameValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_MoreThan5Length_False() {
        // given
        String input = "naming,dobi";
        ValidationResult expected = ValidationResult.failure(ErrorCode.CARNAME_INVALID_LENGTH);

        // when
        ValidationResult actual = carNameValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_WrongCarName_False() {
        // given
        String input = "pobi@,dobi";
        ValidationResult expected = ValidationResult.failure(ErrorCode.CARNAME_INVALID_FORMAT);

        // when
        ValidationResult actual = carNameValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }

    @Test
    void validate_WrongDelimiter_False() {
        // given
        String input = "pobi;woni;jun";
        ValidationResult expected = ValidationResult.failure(ErrorCode.CARNAME_INVALID_DELIMITER);

        // when
        ValidationResult actual = carNameValidator.validate(input);

        // then
        assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(expected);
    }
}