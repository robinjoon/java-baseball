package baseball.io;

class InputValidator {
    void validate3Digits(int number){
        if(number >= 100 && number <= 999){
            return;
        }
        throw new IllegalArgumentException();
    }

    void validateNonIncludeZero(int number){
        String numberString = String.format("%d", number);
        if (numberString.contains("0")){
            throw new IllegalArgumentException();
        }
    }
}
