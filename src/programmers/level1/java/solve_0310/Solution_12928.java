package programmers.level1.java.solve_0310;

import java.util.stream.*;

public class Solution_12928 {
    public int solution(int n) {
        return IntStream.rangeClosed(1, n).filter(e -> n % e == 0).sum();
    }
}
