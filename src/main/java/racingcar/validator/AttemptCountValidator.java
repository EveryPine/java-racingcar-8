package racingcar.validator;

public class AttemptCountValidator {

    private final int MIN_ATTEMPT_COUNT = 1;
    private final int MAX_ATTEMPT_COUNT = 100;

    public boolean validate(String input) {
        boolean isValid = true;

        try {
            int attemptCount = Integer.parseInt(input);

            if (attemptCount < MIN_ATTEMPT_COUNT || attemptCount > MAX_ATTEMPT_COUNT) {
                isValid = false;
            }
        } catch (NumberFormatException e) {
            isValid = false;
        }

        return isValid;
    }
}
