package greedy.java;

import java.io.*;
import java.util.regex.*;

class Solution_14659 {
    private final int len;
    private final int[] inputs;

    Solution_14659(int len, int[] inputs) {
        this.len = len;
        this.inputs = inputs;
    }

    public int getAnswer() {
        int presentValue = 0;
        int presentKill = 0;
        int answer = 0;

        for(int i = 0; i < len; i++) {
            if(presentValue < inputs[i]) {
                presentValue = inputs[i];
                presentKill = 0;
            } else {
                presentKill++;
                if(answer < presentKill) {
                    answer = presentKill;
                }
            }
        }
        return answer;
    }
}

public class Problem_14659 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        int[] inputs = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();

        System.out.println(new Solution_14659(len, inputs).getAnswer());
    }
}
