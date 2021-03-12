package programmers.level1.java.solve_0311;

public class Solution_12943 {
    public int solution(int num) {
        int tmp = num;
        int answer = 0;
        while(tmp != 1 && answer <= 500) {
            if(tmp % 2 == 0) {
                tmp /= 2;
                answer++;
            } else {
                tmp = tmp * 3 + 1;
                answer++;
            }
        }
        return answer > 500 ? -1 : answer;
    }
}
