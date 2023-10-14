package baseball.io;

import baseball.domain.RestartType;
import camp.nextstep.edu.missionutils.Console;

public class InputProcessor {
    private final InputValidator inputValidator;

    public InputProcessor(InputValidator inputValidator) {
        this.inputValidator = inputValidator;
    }

    public int get3DigitsNumber(){
        return get3DigitsNumber(Console.readLine());
    }

    int get3DigitsNumber(String userInput){
        int number;
        try {
            number = Integer.parseInt(userInput);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력");
        }
        inputValidator.validate3Digits(number);
        inputValidator.validateNonIncludeZero(number);
        return number;
    }

    public RestartType getRestartInput(){
        return getRestartInput(Console.readLine());
    }

    RestartType getRestartInput(String userInput){
        try {
            int number = Integer.parseInt(userInput);
            return RestartType.fromInt(number);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("잘못된 입력");
        }
    }
}
