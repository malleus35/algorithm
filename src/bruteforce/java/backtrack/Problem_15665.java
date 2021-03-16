package bruteforce.java.backtrack;
import java.io.*;
import java.util.*;

class Solution_15665 {
    private final int n;
    private final int m;
    private final int[] inputNums;
    private final StringBuilder builder = new StringBuilder();
    private final ArrayList<Integer> nums = new ArrayList<>();
    private final LinkedHashSet<String> set = new LinkedHashSet<>();

    Solution_15665(int[] nAndM, int[] inputNums) {
        this.n = nAndM[0];
        this.m = nAndM[1];
        this.inputNums = inputNums;
    }

    private void backTrack(int depth) {
        if(depth == m) {
            StringBuilder verifyDupulication = new StringBuilder();
            for(int i : nums) {
                verifyDupulication.append(i).append(" ");
            }
            verifyDupulication.append("\n");
            set.add(verifyDupulication.toString());
            return;
        }
        for(int i = 0; i < n; i++) {
            nums.add(inputNums[i]);
            backTrack(depth + 1);
            nums.remove(depth);
        }
    }

    public String getAnswer() {
        backTrack(0);
        for(String i : set) {
            builder.append(i);
        }
        return builder.toString();
    }
}

public class Problem_15665 {
    public static int[] getIntArrToString(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }
    public static int[] getSortedIntArrToString(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = getIntArrToString(reader.readLine());
        int[] inputNums = getSortedIntArrToString(reader.readLine());
        System.out.println(new Solution_15665(nAndM, inputNums).getAnswer());
    }
}
