package programmers.level1.java.solve_0311;

import java.util.*;
import java.util.stream.*;

public class Solution_12933 {
    public long solution(long n) {
        List<Integer> arr = Arrays.stream(String.valueOf(n).split("")).map(Integer::parseInt).sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        return Long.parseLong(arr.stream().map(String::valueOf).collect(Collectors.joining()));
    }
}
