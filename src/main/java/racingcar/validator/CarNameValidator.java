package racingcar.validator;

import java.util.regex.Pattern;

public class CarNameValidator {

    private final Pattern INPUT_PATTERN = Pattern.compile("[a-zA-Z]{1,5}(,[a-zA-Z]{1,5}){0,49}");

    public boolean validate(String input) {
        boolean isValid = true;

        if (input == null) {
            isValid = false;
        }

        if (input != null && !INPUT_PATTERN.matcher(input).matches()) {
            isValid = false;
        }

        return isValid;
    }
}
