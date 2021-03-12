package programmers.level1.java.solutIon_0312;

import com.sun.jdi.PathSearchingVirtualMachine;

import java.util.*;


public class Solution_12977 {
    private static class Solve {
        private final boolean[] isDivided;
        private final boolean[] isVisited;
        private final ArrayList<Integer> answerList = new ArrayList<>();
        private final int[] nums;
        private int answer = 0;

        Solve(int[] nums) {
            this.nums = nums;
            this.isDivided = new boolean[Arrays.stream(nums).sum() + 1];
            this.isVisited = new boolean[nums.length];
        }

        private void checkPrime() {
            int len = Arrays.stream(nums).sum() + 1;
            isDivided[0] = true;
            isDivided[1] = true;
            for (int i = 2; i < len; i++) {
                if (isDivided[i]) continue;
                for (int j = i; j < len; j += i) {
                    if(j == i && isDivided[j]) break;
                    if(j != i && !isDivided[j]) isDivided[j] = true;
                }
            }
        }

        private void dfs(int present, int depth) {
            if (depth == 3) {
                int tmp = answerList.stream().mapToInt(i -> i).sum();
                if(!isDivided[tmp])
                    answer++;
                return;
            }
            for (int i = present; i < isVisited.length; i++) {
                if(isVisited[i]) continue;
                isVisited[i] = true;
                answerList.add(nums[i]);
                dfs(i,depth + 1 );
                answerList.remove(depth);
                isVisited[i] = false;
            }
        }
        public int solve() {
            checkPrime();
            dfs(0, 0);
            return answer;
        }
    }

    public int solution(int[] nums) {
        int answer = new Solve(nums).solve();
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_12977().solution(new int[]{1,2,7,6,4,}));
    }
}
