package baseball.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class GameResultOutputProcessorTest {

    private final GameResultOutputProcessor outputProcessor = new GameResultOutputProcessor();

    final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    final PrintStream standardOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    void printNothing() {
        outputProcessor.printNothing();
        assertEquals("낫싱", outputStreamCaptor.toString().trim());
    }

    @Test
    void printBallAndStrike() {
        outputProcessor.printBallAndStrike(1, 2);
        assertEquals("1볼 2스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    void printBall() {
        outputProcessor.printBall(1);
        assertEquals("1볼", outputStreamCaptor.toString().trim());
    }

    @Test
    void printStrike() {
        outputProcessor.printStrike(1);
        assertEquals("1스트라이크", outputStreamCaptor.toString().trim());
    }

    @Test
    void printGameEnd(){
        outputProcessor.printGameEnd();
        assertEquals("3스트라이크\n" +
                "3개의 숫자를 모두 맞히셨습니다! 게임 종료", outputStreamCaptor.toString().trim());
    }
}