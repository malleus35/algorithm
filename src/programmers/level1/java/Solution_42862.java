package programmers.level1.java;

import java.util.*;

public class Solution_42862 {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int[] checkReserve = new int[30];
        int[] cloneLost = Arrays.stream(lost.clone()).sorted().map(e -> e - 1).toArray();
        int[] cloneReserve = Arrays.stream(reserve.clone()).sorted().map(e -> e - 1).toArray();
        Arrays.fill(checkReserve, 1);
        Arrays.stream(cloneReserve).forEach(e -> checkReserve[e]++);
        Arrays.stream(cloneLost).forEach(e -> checkReserve[e]--);
        for (int i = 0; i < cloneReserve.length; i++) {
            if (cloneReserve[i] == 0) {
                if (checkReserve[cloneReserve[i]] == 2 && checkReserve[cloneReserve[i] + 1] == 0) {
                    checkReserve[cloneReserve[i]]--;
                    checkReserve[cloneReserve[i] + 1]++;
                }
                continue;
            }
            if (cloneReserve[i] == checkReserve.length - 1) {
                if (checkReserve[cloneReserve[i]] == 2 && checkReserve[cloneReserve[i] - 1] == 0) {
                    checkReserve[cloneReserve[i]]--;
                    checkReserve[cloneReserve[i] - 1]++;
                }
                continue;
            }
            if (checkReserve[cloneReserve[i]] == 2 && checkReserve[cloneReserve[i] - 1] == 0) {
                checkReserve[cloneReserve[i]]--;
                checkReserve[cloneReserve[i] - 1]++;
            }
            if (checkReserve[cloneReserve[i]] == 2 && checkReserve[cloneReserve[i] + 1] == 0) {
                checkReserve[cloneReserve[i]]--;
                checkReserve[cloneReserve[i] + 1]++;
            }
        }
        answer = (int) Arrays.stream(checkReserve).limit(n).filter(e -> e > 0).count();
        return answer;
    }
}

