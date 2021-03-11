package programmers.level1.java.solve_0310;

public class Solution_12930 {
    public String solution(String s) {
        String[] tmp = s.split("");
        StringBuilder answer = new StringBuilder();
        int i = 0;
        for(String letter : tmp) {
            if(letter.equals(" ")) {
                answer.append(" ");
                i = 0;
            }
            else {
                if(i % 2 == 0) answer.append(letter.toUpperCase());
                else answer.append(letter.toLowerCase());
                i++;
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution_12930 test = new Solution_12930();
        System.out.println(test.solution("try to hELLo WORLD"));
    }
}
