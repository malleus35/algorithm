package bruteforce;

import java.io.*;
import java.util.*;

class Solution_2231 {
    private final int input;

    Solution_2231(int input) {
        this.input = input;
    }

    private static int cal(int target) {
        int tmp = target;
        int answer = target;
        ArrayList<Integer> nums = new ArrayList<>();
        while(tmp != 0) {
            nums.add(tmp % 10);
            tmp /= 10;
        }
        nums.sort(Comparator.reverseOrder());
        int size = nums.size();
        for (int i = 0; i < size; i++) {
            answer += nums.get(i);
        }
        return answer;
    }

    public int getAnswer() {
        int answer = 0;
        for(int i = 1; i <= input; i++) {
            int tmp = cal(i);
            if(input == tmp) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}

public class Problem_2231 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        System.out.println(new Solution_2231(input).getAnswer());
    }
}


/*
198 -> 216
198 + 1 + 9 + 8 = 216
216 - x / 100 - x / 10 - x / 1 = x;
216 = x + (x / 100) + (x / 10 - (x / 100) * 10 ) + x % 10
x는 항상 주어진 수보다 작음.
자리수가 달라질 경우
95 -> 109
109 -> 95

109 -> x


216 ->
자리수 합의 최대 -> 9,9,9,9,9,9 54
자리수 합 최소 -> 1000000 -> 1
 */