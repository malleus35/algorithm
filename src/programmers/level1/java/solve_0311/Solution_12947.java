package programmers.level1.java.solve_0311;

import java.util.*;

public class Solution_12947 {
    public boolean solution(int x) {
        return x % Arrays.stream(String.valueOf(x).split("")).mapToInt(Integer::parseInt).sum() == 0;
    }
}
