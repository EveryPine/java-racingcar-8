package racingcar.validator;

import racingcar.exception.ErrorCode;

public class AttemptCountValidator extends BaseValidator {

    private final int MIN_ATTEMPT_COUNT = 1;
    private final int MAX_ATTEMPT_COUNT = 100;

    public ValidationResult validate(String input) {
        ValidationResult validationResult = ValidationResult.success();

        if (super.isEmptyInput(input)) {
            validationResult = ValidationResult.failure(ErrorCode.COMMON_EMPTY_INPUT);
            return validationResult;
        }

        if (hasInvalidFormat(input)) {
            validationResult = ValidationResult.failure(ErrorCode.ATTEMPTCOUNT_INVALID_FORMAT);
            return validationResult;
        }

        if (hasInvalidCount(input)) {
            validationResult = ValidationResult.failure(ErrorCode.ATTEMPTCOUNT_INVALID_COUNT);
            return validationResult;
        }

        return validationResult;
    }

    private boolean hasInvalidFormat(String input) {
        boolean invalidFormat = false;

        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            invalidFormat = true;
        }

        return invalidFormat;
    }

    private boolean hasInvalidCount(String input) {
        boolean invalidCount = false;
        int attemptCount = Integer.parseInt(input);

        if (attemptCount < MIN_ATTEMPT_COUNT || attemptCount > MAX_ATTEMPT_COUNT) {
            invalidCount = true;
        }

        return invalidCount;
    }
}
