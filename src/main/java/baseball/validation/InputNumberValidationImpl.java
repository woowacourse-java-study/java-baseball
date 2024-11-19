package baseball.validation;

import baseball.utils.ErrorMessages;

import java.util.HashSet;
import java.util.Set;

public class InputNumberValidationImpl implements InputNumberValidation {
    private static final String RANGE_VALIDATE_SINGLE_NUMBER = "0";
    private static final int RANGE_VALIDATE_NUMBER =3;
    @Override
    public String validate(String number) {
        validateZero(number);
        validateRange(number);
        validateNumber(number);
        validateUniqueDigits(number);
        return number;
    }
    @Override
    public void validateZero(String number) {
        if(number.contains(RANGE_VALIDATE_SINGLE_NUMBER)) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_NUMBER_RANGE);
        }
    }

    @Override
    public void validateRange(String number) {
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
    @Override
    public void validateUniqueDigits(String number) {
        Set<Character> uniqueDigits = new HashSet<>();
        for (char digit : number.toCharArray()) {
            if (!uniqueDigits.add(digit)) {
                throw new IllegalArgumentException(ErrorMessages.INVALID_DUPLICATE_NUMBER);
            }
        }
    }
}
