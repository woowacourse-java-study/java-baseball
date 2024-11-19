package baseball.validation;

public interface InputValidation {
    String validate(String number);

    void validateRange(String number);

    void validateZero(String number);

    void validateNumber(String number);
}
