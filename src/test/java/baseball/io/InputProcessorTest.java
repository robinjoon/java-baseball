package baseball.io;

import baseball.domain.RestartType;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;

import static org.junit.jupiter.api.Assertions.*;

class InputProcessorTest {
    private final InputProcessor inputProcessor = new InputProcessor(new InputValidator());
    @Test
    void get3DigitsNumber() {
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.get3DigitsNumber("100"));
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.get3DigitsNumber("99"));
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.get3DigitsNumber("9999"));
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.get3DigitsNumber("a"));
        assertEquals(111, inputProcessor.get3DigitsNumber("111"));
        assertEquals(193, inputProcessor.get3DigitsNumber("193"));
    }

    @Test
    void getRestartInput() {
        assertEquals(RestartType.RESTART, inputProcessor.getRestartInput("1"));
        assertEquals(RestartType.END, inputProcessor.getRestartInput("2"));
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.getRestartInput("3"));
        assertThrows(IllegalArgumentException.class, () -> inputProcessor.getRestartInput("a"));
    }
}