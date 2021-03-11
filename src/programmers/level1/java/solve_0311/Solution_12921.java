package programmers.level1.java.solve_0311;
import java.util.*;
public class Solution_12921 {
    public int solution(int n) {
        int[] nums = new int[n + 1];
        nums[0] = 1;
        nums[1] = 1;
        for(int i = 2; i <= (n / 2); i++) {
            if(nums[i] == 1) continue;
            for(int j = i; j <= n; j+=i) {
                if(j == i && nums[j] == 1) break;
                if(i != j && nums[j] == 0) nums[j] = 1;
            }
        }
        return (int) Arrays.stream(nums).filter(e -> e == 0).count();
    }
}
