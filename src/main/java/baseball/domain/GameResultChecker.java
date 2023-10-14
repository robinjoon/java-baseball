package baseball.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class GameResultChecker {
    private final int[] answerArray;
    private static final int ARRAY_SIZE = 3;

    GameResultChecker(int answer) {
        answerArray = new int[ARRAY_SIZE];
        answerArray[0] = answer / 100;
        answerArray[1] = (answer % 100) / 10;
        answerArray[2] = (answer % 100) % 10;
    }

    GameResult gameResult(int userInput){
        int[] userInputArray = new int[ARRAY_SIZE];
        userInputArray[0] = userInput / 100;
        userInputArray[1] = (userInput % 100) / 10;
        userInputArray[2] = (userInput % 100) % 10;

        int strikeCount = calcStrikeCount(userInputArray);
        int ballCount = calcBallCount(userInputArray);

        return new GameResult(ballCount, strikeCount);
    }

    private int calcStrikeCount(int[] userInputArray){
        return (int) IntStream.range(0, ARRAY_SIZE)
                .filter(i -> userInputArray[i] == answerArray[i])
                .count();
    }

    private int calcBallCount(int[] userInputArray){
        List<Integer> answerList = Arrays.stream(answerArray)
                .boxed()
                .collect(Collectors.toList());

        return (int) IntStream.range(0, ARRAY_SIZE)
                .filter(i -> answerArray[i] != userInputArray[i] && answerList.contains(userInputArray[i]))
                .count();
    }
}
