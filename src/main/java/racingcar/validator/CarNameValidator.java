package racingcar.validator;

import racingcar.exception.ErrorCode;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class CarNameValidator extends BaseValidator{

    private final int MIN_CAR_COUNT = 1;
    private final int MAX_CAR_COUNT = 50;
    private final Pattern ALPHABET_ONLY_PATTERN = Pattern.compile("^[a-zA-Z]+$");
    private final Pattern CARNAME_PATTERN = Pattern.compile("^[a-zA-Z]{1,5}$");
    private final String INPUT_DELIMITER = ",";

    public ValidationResult validate(String input) {
        ValidationResult validationResult = ValidationResult.success();

        if (super.isEmptyInput(input)) {
            validationResult = ValidationResult.failure(ErrorCode.COMMON_EMPTY_INPUT);
            return validationResult;
        }

        if (hasInvalidDelimiter(input)) {
            validationResult = ValidationResult.failure(ErrorCode.CARNAME_INVALID_DELIMITER);
            return validationResult;
        }

        if (hasInvalidFormat(input)) {
            validationResult = ValidationResult.failure(ErrorCode.CARNAME_INVALID_FORMAT);
            return validationResult;
        }

        if (hasInvalidLength(input)) {
            validationResult = ValidationResult.failure(ErrorCode.CARNAME_INVALID_LENGTH);
            return validationResult;
        }

        if (hasInvalidCount(input)) {
            validationResult = ValidationResult.failure(ErrorCode.CARNAME_INVALID_COUNT);
            return validationResult;
        }

        return validationResult;
    }

    private boolean hasInvalidDelimiter(String input) {
        boolean invalidDelimiter = false;

        if (!input.contains(INPUT_DELIMITER)) {
            invalidDelimiter = true;
        }

        return invalidDelimiter;
    }

    private boolean hasInvalidFormat(String input) {
        boolean invalidFormat = false;
        List<String> carNames = Arrays.asList(input.split(INPUT_DELIMITER));

        for (String carName : carNames) {
            if (!ALPHABET_ONLY_PATTERN.matcher(carName).matches()) {
                invalidFormat = true;
            }
        }

        return invalidFormat;
    }

    private boolean hasInvalidLength(String input) {
        boolean invalidLength = false;
        List<String> carNames = Arrays.stream(input.split(INPUT_DELIMITER)).toList();

        for (String carName : carNames) {
            if (!CARNAME_PATTERN.matcher(carName).matches()) {
                invalidLength = true;
            }
        }

        return invalidLength;
    }

    private boolean hasInvalidCount(String input) {
        boolean invalidCount = false;
        int carCount = Arrays.stream(input.split(INPUT_DELIMITER)).toList().size();

        if (carCount < MIN_CAR_COUNT || carCount > MAX_CAR_COUNT) {
            invalidCount = true;
        }

        return invalidCount;
    }
}
