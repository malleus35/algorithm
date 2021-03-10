package programmers.level1.java.solve_0310;

public class Solution_70128 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        int len = a.length;
        for(int i = 0; i < len; i++) {
            answer += a[i] * b[i];
        }
        return answer;
    }
}
