package greedy;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_4796 {
    private final int[] inputs;

    Solution_4796(int[] inputs) {
        this.inputs = inputs;
    }

    public int getAnswer() {
        int answer = 0;
        answer = (inputs[2] / inputs[1]) * inputs[0] + Math.min((inputs[2] % inputs[1]), inputs[0]);
        return answer;
    }
}

public class Problem_4796 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = "";
        int i = 1;
        while((input = reader.readLine()) != null) {
            int[] tmp = Pattern.compile(" ").splitAsStream(input).mapToInt(Integer::parseInt).toArray();
            if(Arrays.stream(tmp).allMatch(x -> x == 0))
                break;
            System.out.println("Case " + i++ + ": " + new Solution_4796(tmp).getAnswer());
        }
    }
}
