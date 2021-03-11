package programmers.level1.java.solve_0311;
import java.util.*;

public class Solution_1845 {
    public int solution(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int getMon = 0;
        for(int i : nums) {
            if(getMon >= nums.length / 2) break;
            if(!map.containsValue(i)) {
                map.put(i, i);
                getMon++;
            }
        }
        return map.size();
    }
}
