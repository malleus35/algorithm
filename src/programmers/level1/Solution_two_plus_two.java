package programmers.level1;

import java.util.*;

public class Solution_two_plus_two {
    public int[] solution(int[] numbers) {
        HashSet<Integer> tmp = new HashSet<>();
        int len = numbers.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j)
                    tmp.add(numbers[i] + numbers[j]);
            }
        }
        return tmp.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}

