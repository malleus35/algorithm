package programmers.level1.java.solve_0310;

import java.util.*;
import java.util.stream.*;

public class Solution_12917 {
    public String solution(String s) {
        return Arrays.stream(s.split("")).sorted(Collections.reverseOrder()).collect(Collectors.joining());
    }
}
