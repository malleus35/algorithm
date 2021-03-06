package math.java;

import java.io.*;

class Solution_2011 {
    private String[] input;
    private long[][] memo;

    Solution_2011(String[] input) {
        this.input = input;
        this.memo = new long[input.length + 1][2];

        memo[1][0] = 1;
        memo[1][1] = 0;
    }

    public long getAnswer() {
        final int div = 1000000;
        int length = input.length;
        for(int i = 2; i <= length; i++) {
            memo[i][0] = (memo[i - 1][0] % div + memo[i - 1][1] % div) % div;
            if(input[i - 1].equals("0")) {
                if(input[i].equals("0")) return 0;
                else {
                }
            }
            if(input[i - 1].equals("1")) {

            } else if(input[i - 1].equals("2")) {
                if(Integer.parseInt(input[i]) <= 3) {

                }
            }
        }
        return 0;
    }
}

public class Problem_2011 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input =  reader.readLine().split("");
        System.out.println(new Solution_2011(input).getAnswer());
    }
}
