package baseball.validation;

public interface InputValidation {
    int vlalidate(String number);

    void validateRange(String number);

    void validateZero(String number);

    int validateNumber(String number);
}
