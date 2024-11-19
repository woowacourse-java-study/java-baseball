package baseball.validation;

import baseball.utils.ErrorMessages;

public class InputUserChoiceValidationImpl implements InputUserChoiceValidation{
    @Override
    public int validate(String number) {
        validateRange(number);
        return validateNumber(number);

    }
    @Override
    public void validateRange(String number) {
        if (!number.equals("1") && !number.equals("2")) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_CHOICE_RANGE);
        }
    }

    @Override
    public int validateNumber(String number) {
        try {
           return Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_FORMAT);
        }
    }
}
