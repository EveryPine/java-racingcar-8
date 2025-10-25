package racingcar.validator;

import racingcar.exception.ErrorCode;

public class ValidationResult {

    private boolean success;
    private ErrorCode errorCode;

    private ValidationResult(boolean success, ErrorCode errorCode) {
        this.success = success;
        this.errorCode = errorCode;
    }

    public static ValidationResult success() {
        return new ValidationResult(true, null);
    }

    public static ValidationResult failure(ErrorCode errorCode) {
        return new ValidationResult(false, errorCode);
    }

    public boolean isFailure() {
        return !success;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

}
