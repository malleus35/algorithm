package programmers.level1.java;

import java.util.*;

public class Solution_42748 {
    public int[] solution(int[] array, int[][] commands) {
        ArrayList<Integer> answer = new ArrayList<>();
        for(int[] command : commands) {
            int i = command[0];
            int j = command[1];
            int k = command[2];
            int[] splitArr = Arrays.copyOfRange(array, i - 1, j);
            Arrays.sort(splitArr);
            answer.add(splitArr[k - 1]);
        }
        return answer.stream().mapToInt(e -> e).toArray();
    }
}
