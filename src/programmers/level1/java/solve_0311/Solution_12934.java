package programmers.level1.java.solve_0311;

import java.util.*;

public class Solution_12934 {
    public long solution(long n) {
        double sqrt = Math.sqrt(n);
        long answer = 0;
        if((long) (sqrt * sqrt) == n) {
            answer += (long) sqrt + 1;
            answer *= answer;
        } else answer = -1;
        return answer;
    }
}
