package programmers.level1.java;

public class Solution_12903 {
    public String solution(String s) {
        int len = s.length();
        int middle = len / 2;
        return len % 2 != 0 ? s.substring(middle, middle + 1) : s.substring(middle - 1, middle + 1);
    }
}
