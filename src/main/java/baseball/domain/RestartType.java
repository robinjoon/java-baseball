package baseball.domain;

public enum RestartType {
    RESTART,
    END;

    public static RestartType fromInt(int number){
        if(number == 1){
            return RESTART;
        }
        if(number == 2){
            return END;
        }
        throw new IllegalArgumentException("잘못된 숫자입니다. 1 혹은 2만 가능합니다.");
    }
}
