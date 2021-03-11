package programmers.level1.java.solve_0311;
import java.util.*;
public class Solution_12935 {
    public int[] solution(int[] arr) {
        int min = Arrays.stream(arr).min().getAsInt();
        int[] answer = Arrays.stream(arr).filter(e -> e > min).toArray();
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}
