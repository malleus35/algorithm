package programmers.level1.java.solve_0310;

import java.util.*;
import java.util.stream.*;

public class Solution_12918 {
    public boolean solution(String s) {
        int len = Arrays.stream(s.split("")).filter("0123456789"::contains).collect(Collectors.joining()).length();
        return (len == 4 || len == 6) && len == s.length();
    }
}
