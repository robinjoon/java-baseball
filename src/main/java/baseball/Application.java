package baseball;

import baseball.domain.GameEngine;

public class Application {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        gameEngine.start();
    }
}
