package baseball.domain;

import static baseball.domain.GameResultType.*;

class GameResult {
    private final int ballCount;
    private final int strikeCount;

    public GameResult(int ballCount, int strikeCount) {
        this.ballCount = ballCount;
        this.strikeCount = strikeCount;
    }

    int getBallCount() {
        return ballCount;
    }

    int getStrikeCount() {
        return strikeCount;
    }

    GameResultType getResultType(){
        if(ballCount == 0 && strikeCount == 0){
            return NOT_THING;
        }
        if(strikeCount == 3){
            return END;
        }
        if (strikeCount >= 1 && ballCount >=1){
            return BALL_STRIKE;
        }
        if (ballCount >=1){
            return BALL;
        }
        if (strikeCount >= 1){
            return STRIKE;
        }
        throw new IllegalStateException("불가능한 게임 결과");
    }

}
