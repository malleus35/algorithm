package bruteforce;

import java.util.*;
import java.io.*;
import java.util.regex.*;
import java.util.stream.IntStream;

class Solution_6603 {
    private final int[] inputs;
    private final int len;
    private final ArrayList<Integer> result;

    Solution_6603(int[] inputs) {
        this.len = inputs[0];
        this.inputs = new int[len];
        for(int i = 1; i < inputs.length; i++)
            this.inputs[i - 1] = inputs[i];
        this.result = new ArrayList<>();
    }

    private void backTrack(StringBuilder resultBuilder, int depth) {
        if(depth == 6) {
            for(int i = 0; i < 5; i++) {
                resultBuilder.append(result.get(i)).append(" ");
            }
            resultBuilder.append(result.get(5)).append("\n");
            return;
        }
        for(int i = 0; i < len; i++) {
            if(result.size() > 0)
                if(result.get(depth - 1) >= inputs[i]) continue;
            result.add(inputs[i]);
            backTrack(resultBuilder, depth + 1);
            result.remove(depth);
        }
    }

    public String getAnswer() {
        StringBuilder resultBuilder = new StringBuilder();
        backTrack(resultBuilder,0);
        resultBuilder.append("\n");
        return resultBuilder.toString();
    }
}

public class Problem_6603 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String tmp = "";
        while((tmp = reader.readLine()) != null) {
            int[] input = Pattern.compile(" ").splitAsStream(tmp).mapToInt(Integer::parseInt).toArray();
            if(input[0] == 0) return;
            System.out.print(new Solution_6603(input).getAnswer());
        }
    }
}
