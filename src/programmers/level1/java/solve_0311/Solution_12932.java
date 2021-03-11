package programmers.level1.java.solve_0311;
import java.util.*;
import java.util.stream.*;
public class Solution_12932 {
    public int[] solution(long n) {
        List<Integer> answerList = Arrays.stream(String.valueOf(n).split("")).map(Integer::parseInt).collect(Collectors.toList());
        Collections.reverse(answerList);
        return answerList.stream().mapToInt(Integer::intValue).toArray();
    }
}
