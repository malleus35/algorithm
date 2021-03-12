package programmers.level1.java.solve_0311;

public class Solution_12948 {
    public String solution(String phone_number) {
        StringBuilder answer = new StringBuilder();
        String[] nums = phone_number.split("");
        for(int i = 0; i < nums.length; i++) {
            if(i < nums.length - 4) {
                answer.append("*");
            } else answer.append(nums[i]);
        }
        return answer.toString();
    }
}
