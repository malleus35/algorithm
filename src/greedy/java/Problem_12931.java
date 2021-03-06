package greedy.java;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_12931 {
    private final int size;
    private final int[] inputs;
    private int[] tmp;

    Solution_12931(int size, int[] inputs) {
        this.size = size;
        this.inputs = inputs;
        this.tmp = inputs.clone();
    }

    private boolean isAllZero() {
        return Arrays.stream(tmp).allMatch(x -> x == 0);
    }

    private boolean isAllAbleToDivide() {
        return Arrays.stream(tmp).filter(x -> x % 2 == 0).count() == size + 1;
    }

    public int getAnswer() {
        int answer = 0;
        while (!isAllZero()) {
            if (isAllAbleToDivide()) {
                tmp = Arrays.stream(tmp).map(x -> x / 2).toArray();
                answer++;
            } else {
                for (int i = 1; i <= size; i++) {
                    if (tmp[i] % 2 != 0) {
                        tmp[i]--;
                        break;
                    }
                }
                answer++;
            }
        }

        return answer;
    }


}

public class Problem_12931 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());
        int[] inputs = Pattern.compile(" ").splitAsStream("0 " + reader.readLine()).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solution_12931(size, inputs).getAnswer());
    }
}
