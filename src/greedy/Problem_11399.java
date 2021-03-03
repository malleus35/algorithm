package greedy;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_11399 {
    private final int len;
    private final int[] inputs;

    Solution_11399(int len, int[] inputs) {
        this.len = len;
        this.inputs = inputs;
    }

    public int getAnswer() {
        int answer = 0;
        int accu = 0;
        for(int i = 1; i <= len; i++) {
            accu += inputs[i];
            answer += accu;
        }
        return answer;
    }

}

public class Problem_11399 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] inputs = Pattern.compile(" ").splitAsStream("0 " + reader.readLine()).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(new Solution_11399(len, inputs).getAnswer());
    }
}
