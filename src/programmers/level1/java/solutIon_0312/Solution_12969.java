package programmers.level1.java.solutIon_0312;

import java.util.*;
import java.io.*;

public class Solution_12969 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int column = inputs[1];
        int row = inputs[0];
        for(int i = 0; i < column; i++) {
            for(int j = 0; j < row; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
