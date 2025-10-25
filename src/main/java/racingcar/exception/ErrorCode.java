package racingcar.exception;

public enum ErrorCode {

    // 공통 예외코드
    COMMON_EMPTY_INPUT          (100, "입력값이 비어있습니다."),

    // 자동차 입력 예외코드
    CARNAME_INVALID_DELIMITER   (200, "구분자는 쉼표(,)만 사용 가능합니다."),
    CARNAME_INVALID_FORMAT      (201, "자동차 이름은 알파벳으로 이루어진 문자열만 사용 가능합니다."),
    CARNAME_INVALID_LENGTH      (202, "자동차 이름은 1~5자 문자열만 사용 가능합니다."),
    CARNAME_INVALID_COUNT       (203, "자동차 개수는 1 이상 50 이하의 정수값이여야 합니다."),

    // 시도횟수 입력 예외코드
    ATTEMPTCOUNT_INVALID_FORMAT (300, "시도 횟수에는 숫자만 입력 가능합니다."),
    ATTEMPTCOUNT_INVALID_COUNT  (301, "시도 횟수는 1 이상 100 이하의 정수값이어야 합니다"),;

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
