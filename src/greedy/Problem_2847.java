package greedy;

import java.io.*;

class Solution_2847 {
    private final int len;
    private final int[] inputs;

    Solution_2847(int len, int[] inputs) {
        this.len = len;
        this.inputs = inputs;
    }

    public int getAnswer() {
        int present = 0;
        int prev = 0;
        int answer = 0;

        for(int i = len; i >= 1; i--) {
            present = inputs[i];
            prev = inputs[i - 1];

            if(present > prev)
                continue;
            else {
                int sub = prev - present + 1;
                inputs[i - 1] -= sub;
                answer += sub;
            }
        }
        return answer;
    }
}

public class Problem_2847 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] inputs = new int[len + 1];

        for(int i = 1; i <= len; i++)
            inputs[i] = Integer.parseInt(reader.readLine());

        System.out.println(new Solution_2847(len, inputs).getAnswer());
    }
}
