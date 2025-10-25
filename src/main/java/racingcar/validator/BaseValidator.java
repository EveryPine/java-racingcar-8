package racingcar.validator;

public class BaseValidator {

    protected boolean isEmptyInput(String input) {
        boolean emptyInput = false;

        if (input == null || input.isEmpty()) {
            emptyInput = true;
        }

        return emptyInput;
    }
}
