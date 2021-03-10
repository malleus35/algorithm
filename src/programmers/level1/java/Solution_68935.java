package programmers.level1.java;

import java.util.*;
import java.util.stream.*;

public class Solution_68935 {
    public int solution(int n) {
        StringBuilder builder = new StringBuilder();
        int answer = 0;
        int tmp = n;
        while(tmp > 0) {
            builder.append(tmp % 3);
            tmp /= 3;
        }
        List<Integer> arr = Arrays.stream(builder.toString().split("")).map(Integer::parseInt).collect(Collectors.toList());
        int len = arr.toArray().length;
        for(int i = len - 1; i >= 0; i--) {
            answer += arr.get(i) * Math.pow(3, len - i - 1);
        }
        return answer;
    }

    public static void main(String[] args) {
        Solution_68935 test = new Solution_68935();
        System.out.println(test.solution(45));
    }
}
