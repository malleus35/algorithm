package programmers.level1.java;

import java.util.*;

public class Solution_12901 {
    public String solution(int a, int b) {
        String[] WEEKDAYS = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        int[] NUM_OF_DAYS = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        return WEEKDAYS[(Arrays.stream(NUM_OF_DAYS).limit(a - 1).sum() + b - 1) % 7];
    }
}
