package programmers.level1.java.solutIon_0312;

import java.util.*;

public class Solution_17682 {
    public int solution(String dartResult) {
        int[] test = new int[5];
        int[] nums = Arrays.stream(dartResult.split("[DST*#]")).filter(e -> !e.equals("")).mapToInt(Integer::parseInt).toArray();
        int[] squares = new int[3];
        char[] stars = new char[3];
        int[] tmps = new int[3];
        int squareI = 0;
        char[] letters = dartResult.toCharArray();
        for(int i = 0; i < dartResult.length(); i++) {
            if(letters[i] == 'S') {
                squares[squareI] = 1;
                squareI++;
            }
            else if(letters[i] == 'D') {
                squares[squareI] = 2;
                squareI++;
            }
            else if(letters[i] == 'T') {
                squares[squareI] = 3;
                squareI++;
            }
            else if(letters[i] == '*' || letters[i] == '#') {
                stars[squareI - 1] = letters[i];
            }
        }
        for(int i = 0; i < 3; i++) {
            tmps[i] = (int) Math.pow(nums[i], squares[i]);
            if(stars[i] == '*') {
                tmps[i] *= 2;
                if(i != 0) tmps[i - 1] *= 2;
            } else if(stars[i] == '#') {
                tmps[i] *= -1;
            }
        }
        return Arrays.stream(tmps).sum();
    }

    public static void main(String[] args) {
        Solution_17682 test = new Solution_17682();
        System.out.println(test.solution("10S*2T*3S"));
    }
}
