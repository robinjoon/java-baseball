package baseball.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static baseball.domain.GameResultType.*;
import static org.junit.jupiter.api.Assertions.*;

class GameResultCheckerTest {

    private final GameResultChecker gameResultChecker = new GameResultChecker(123);

    @Test
    void gameResult() {
        GameResult gameResult = gameResultChecker.gameResult(456);
        assertEquals(gameResult.getResultType(), NOT_THING);

        gameResult = gameResultChecker.gameResult(156);
        assertEquals(gameResult.getResultType(), STRIKE);
        assertEquals(gameResult.getBallCount(), 0);
        assertEquals(gameResult.getStrikeCount(), 1);

        gameResult = gameResultChecker.gameResult(132);
        assertEquals(gameResult.getResultType(), BALL_STRIKE);
        assertEquals(gameResult.getBallCount(), 2);
        assertEquals(gameResult.getStrikeCount(), 1);

        gameResult = gameResultChecker.gameResult(235);
        assertEquals(gameResult.getResultType(), BALL);
        assertEquals(gameResult.getBallCount(), 2);
        assertEquals(gameResult.getStrikeCount(), 0);

        gameResult = gameResultChecker.gameResult(123);
        assertEquals(gameResult.getResultType(), END);
        assertEquals(gameResult.getBallCount(), 0);
        assertEquals(gameResult.getStrikeCount(), 3);
    }
}