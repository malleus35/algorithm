package programmers.level1.java.solve_0310;

import java.util.*;
import java.util.stream.*;

public class Solution_12912 {
    public long solution(int a, int b) {
        return LongStream.rangeClosed(Math.min(a,b), Math.max(a,b)).sum();
    }
}
