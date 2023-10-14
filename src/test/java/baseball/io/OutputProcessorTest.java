package baseball.io;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class OutputProcessorTest {

    private final OutputProcessor outputProcessor = new OutputProcessor();

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
    void printGameStart() {
        outputProcessor.printGameStart();
        assertEquals("숫자 야구 게임을 시작합니다.", outputStreamCaptor.toString().trim());
    }

    @Test
    void printInput3DigitsNumberGuide() {
        outputProcessor.printInput3DigitsNumberGuide();
        assertEquals("숫자를 입력해주세요 : ", outputStreamCaptor.toString());
    }

    @Test
    void printRestartGuide() {
        outputProcessor.printRestartGuide();
        assertEquals("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.", outputStreamCaptor.toString().trim());
    }
}