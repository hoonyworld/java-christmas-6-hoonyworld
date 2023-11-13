package christmas.view.constant;

public enum IllegalArgumentExceptionType implements ExceptionType<IllegalArgumentException> {
    DECEMBER_DATE_OUT_OF_RANGE("[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."),
    NOT_NUMBER("[ERROR] : 숫자만 입력이 가능합니다");
    private final String message;

    IllegalArgumentExceptionType(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public IllegalArgumentException getException() {
        return new IllegalArgumentException(getMessage());
    }
}
