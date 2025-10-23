package racingcar.validator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameValidatorTest {

    private CarNameValidator carNameValidator = new CarNameValidator();

    @Test
    void validate_Normal_True() {
        //given
        String input = "Pobi,woni,jun";
        boolean expected = true;

        // when
        boolean actual = carNameValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_WithoutCar_False() {
        // given
        String input = "";
        boolean expected = false;

        // when
        boolean actual = carNameValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_MoreThan50Cars_False() {
        // given
        StringBuilder input = new StringBuilder("asdf");
        input.append(",asdf".repeat(50));
        boolean expected = false;

        // when
        boolean actual = carNameValidator.validate(input.toString());

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_MoreThan5CarNameLength_False() {
        // given
        String input = "naming,dobi";
        boolean expected = false;

        // when
        boolean actual = carNameValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_WrongCarName_False() {
        // given
        String input = "pobi@,dobi";
        boolean expected = false;

        // when
        boolean actual = carNameValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }

    @Test
    void validate_WrongDelimiter_False() {
        // given
        String input = "pobi;woni;jun";
        boolean expected = false;

        // when
        boolean actual = carNameValidator.validate(input);

        // then
        assertEquals(expected, actual);
    }
}