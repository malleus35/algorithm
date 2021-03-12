package programmers.level1.java.solutIon_0312;

import java.util.*;
public class Solution_12982 {
    public int solution(int[] d, int budget) {
        int[] tmp = Arrays.stream(d).sorted().toArray();
        int tmpBudget = budget;
        int answer = 0;
        for(int i : tmp) {
            if(tmpBudget - i >= 0) {
                tmpBudget -= i;
                answer++;
            } else break;
        }
        return answer;
    }
}
