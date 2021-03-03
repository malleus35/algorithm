package greedy;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_20044 {
    private final int len;
    private final int[] inputs;

    Solution_20044(int len, int[] inputs) {
        this.len = len;
        this.inputs = inputs;
    }

    public int getAnswer() {
        int size = inputs.length - 1;
        int answer = inputs[1] + inputs[size];
        for(int i = 2; i <= size / 2; i++) {
            int last = size - i + 1;
            answer = answer > inputs[i] + inputs[last] ? inputs[i] + inputs[last] : answer;
        }
        return answer;
    }
}

public class Problem_20044 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] inputs = Pattern.compile(" ").splitAsStream("0 " + reader.readLine()).mapToInt(Integer::parseInt).sorted().toArray();
        System.out.println(new Solution_20044(len, inputs).getAnswer());
    }
}
