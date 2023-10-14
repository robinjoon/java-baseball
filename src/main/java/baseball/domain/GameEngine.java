package baseball.domain;

import baseball.io.GameGuideOutputProcessor;
import baseball.io.GameResultOutputProcessor;
import baseball.io.InputProcessor;
import baseball.io.InputValidator;

import static baseball.domain.GameResultType.*;

public class GameEngine {
    private int answer;
    private final InputProcessor inputProcessor;
    private GameResultChecker gameResultChecker;
    private final GameResultOutputProcessor resultOutputProcessor;
    private final GameGuideOutputProcessor guideOutputProcessor;

    public GameEngine() {
        this.answer = AnswerGenerator.generate();
        this.inputProcessor = new InputProcessor(new InputValidator());
        gameResultChecker = new GameResultChecker(answer);
        this.resultOutputProcessor = new GameResultOutputProcessor();
        this.guideOutputProcessor = new GameGuideOutputProcessor();
    }

    public void start(){
        guideOutputProcessor.printGameStart();
        next();
    }

    private void next(){
        guideOutputProcessor.printInput3DigitsNumberGuide();
        int userInput = inputProcessor.get3DigitsNumber();
        GameResult gameResult = gameResultChecker.gameResult(userInput);
        printGameResult(gameResult);
        if(gameResult.getResultType() == END){
            gameEndOrRestart();
            return;
        }
        next();
    }

    private void gameEndOrRestart() {
        guideOutputProcessor.printRestartGuide();
        RestartType restartType = inputProcessor.getRestartInput();
        if (restartType == RestartType.RESTART){
            answer = AnswerGenerator.generate();
            gameResultChecker = new GameResultChecker(answer);
            next();
        }
    }

    private void printGameResult(GameResult gameResult){
        GameResultType type = gameResult.getResultType();
        if (type == NOT_THING){
            resultOutputProcessor.printNothing();
        }
        if (type == BALL){
            resultOutputProcessor.printBall(gameResult.getBallCount());
        }
        if (type == BALL_STRIKE){
            resultOutputProcessor.printBallAndStrike(gameResult.getBallCount(), gameResult.getStrikeCount());
        }
        if (type == STRIKE){
            resultOutputProcessor.printStrike(gameResult.getStrikeCount());
        }
        if (type == END){
            resultOutputProcessor.printGameEnd();
        }
    }
}
