package programmers.level1.java.solve_0311;

import java.util.Arrays;

public class Solution_12944 {
    public double solution(int[] arr) {
        return Arrays.stream(arr).average().getAsDouble();
    }
}
