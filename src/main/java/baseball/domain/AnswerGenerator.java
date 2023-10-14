package baseball.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

class AnswerGenerator {
    static int generate(){
        Set<Integer> numberSet = new HashSet<>();
        while (numberSet.size() < 3){
            numberSet.add(Randoms.pickNumberInRange(1, 9));
        }
        String result = numberSet.stream()
                .map(String::valueOf)
                .collect(Collectors.joining());
        return Integer.parseInt(result);
    }
}
