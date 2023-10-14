package baseball.io;

public class GameResultOutputProcessor {
    public void printNothing(){
        System.out.println("낫싱");
    }

    public void printBallAndStrike(int ballCount, int strikeCount){
        String result = String.format("%d볼 %d스트라이크", ballCount, strikeCount);
        System.out.println(result);
    }

    public void printBall(int ballCount){
        String result = String.format("%d볼", ballCount);
        System.out.println(result);
    }

    public void printStrike(int strikeCount){
        String result = String.format("%d스트라이크", strikeCount);
        System.out.println(result);
    }

    public void printGameEnd(){
        printStrike(3);
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }
}
