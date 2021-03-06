package bruteforce.java;

import java.util.*;
import java.io.*;

class Solution_2309 {
    private final int[] sortedDrawf;
    private final int sumOfHeight;
    private final int[] excluded;

    Solution_2309(int[] sortedDrawf, int sumOfHeight) {
        this.sortedDrawf = sortedDrawf;
        this.sumOfHeight = sumOfHeight;
        this.excluded = new int[2];
    }

    public String getAnswer() {
        StringBuilder resultBuilder = new StringBuilder();
        boolean isFind = false;
        for(int i = 0; i < 9; i++) {
            if(isFind) break;
            excluded[0] = sortedDrawf[i];
            for(int j = 0; j < 9; j++) {
                if(j == i) continue;
                excluded[1] = sortedDrawf[j];
                if(sumOfHeight - (excluded[0] + excluded[1]) == 100) {
                    isFind = true;
                    break;
                }
            }
        }
        for(int i = 0; i < 9; i++) {
            int finalI = i;
            if(Arrays.stream(excluded).noneMatch(x -> x == sortedDrawf[finalI])) {
                resultBuilder.append(sortedDrawf[i]).append("\n");
            }
        }
        return resultBuilder.toString();
    }
}

public class Problem_2309 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] dwarf = new int[9];
        for(int i = 0; i < 9; i++) {
            dwarf[i] = Integer.parseInt(reader.readLine());
        }
        int[] sortedDrawf = Arrays.stream(dwarf).sorted().toArray();
        int sumOfHeight = Arrays.stream(sortedDrawf).sum();
        System.out.println(new Solution_2309(sortedDrawf, sumOfHeight).getAnswer());
    }
}
