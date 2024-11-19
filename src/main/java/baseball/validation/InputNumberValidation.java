package baseball.validation;

public interface InputNumberValidation {
    String validate(String number);

    void validateRange(String number);

    void validateZero(String number);

    void validateNumber(String number);
}
