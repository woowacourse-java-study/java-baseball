package baseball.validation;

import baseball.utils.ErrorMessages;

public class InputValidationImpl implements InputValidation {
    private static final String RANGE_VALIDATE_SINGLE_NUMBER = "0";
    private static final int RANGE_VALIDATE_NUMBER =3;
    @Override
    public String validate(String number) {
        validateZero(number);
        validateRange(number);
        validateNumber(number);
        return number;
    }
    @Override
    public void validateRange(String number) {
        if(number.contains(RANGE_VALIDATE_SINGLE_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE);
        }
    }

    @Override
    public void validateZero(String number) {
        if((number.length()!=RANGE_VALIDATE_NUMBER)){
            throw new IllegalArgumentException(ErrorMessages.INVALID_INPUT_COUNT);
        }
    }

    @Override
    public void validateNumber(String number) {
        try {
          Integer.parseInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_FORMAT);
        }
    }
}
