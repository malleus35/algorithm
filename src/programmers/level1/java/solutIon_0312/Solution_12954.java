package programmers.level1.java.solutIon_0312;

import java.util.*;


public class Solution_12954 {
    public long[] solution(int x, int n) {
        ArrayList<Long> list = new ArrayList<>();
        long tmp = 0;
        for(int i = 1; i <= n; i++) {
            tmp += x;
            list.add(tmp);
        }
        return list.stream().mapToLong(l -> l).toArray();
    }
}
