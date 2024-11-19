package baseball.validation;

public interface InputUserChoiceValidation {
    int validate(String number);

    void validateRange(String number);

    int validateNumber(String number);
}
