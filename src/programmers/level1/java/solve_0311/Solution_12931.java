package programmers.level1.java.solve_0311;
import java.util.*;

public class Solution_12931 {
    public int solution(int n) {
        return Arrays.stream(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
    }
}
