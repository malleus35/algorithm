package programmers.level1.java.solve_0310;

import java.util.*;

public class Solution_12910 {
    public int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(e -> e % divisor == 0).sorted().toArray();
        if(answer.length == 0) answer = new int[]{-1};
        return answer;
    }
}
