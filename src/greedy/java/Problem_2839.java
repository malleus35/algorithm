package greedy.java;

import java.util.*;

class Solution_2839 {
    private final int input;

    Solution_2839(int input) {
        this.input = input;
    }

    public int getAnswer() {
        int answer = input / 5;
        int sugar = input % 5;
        while (sugar > 0) {
            if(answer == 0) {
                if(sugar % 3 != 0) {
                    answer = -1;
                    break;
                }
                else {
                    answer += sugar / 3;
                    sugar = 0;
                }
            } else {
                if(sugar % 3 == 0) {
                    answer += sugar / 3;
                    break;
                }
                else {
                    answer--;
                    sugar += 5;
                }
            }
        }
//        if (input % 5 == 0)
//            answer += input / 5;
//        else if (input % 5 == 3)
//            answer += input / 5 + 1;
//        else if (input % 3 == 0)
//            answer += input / 3;
//        else answer = -1;
        return answer;
    }
}

public class Problem_2839 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        System.out.println(new Solution_2839(input).getAnswer());
    }
}
