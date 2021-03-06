package implementation.java;

import java.io.*;
import java.util.regex.*;

class Solution_1051 {
    private final int height;
    private final int width;
    private final int[][] map;

    Solution_1051(int height, int width, int[][] map) {
        this.height = height;
        this.width  = width;
        this.map = map;
    }

    public int getAnswer() {
        int answer = 0;
        int maxHeight = 1;
        int maxWidth = 1;
        for(int upperHeight = 0; upperHeight < height; upperHeight++) {
            for(int underHeight = height - 1; underHeight > 0; underHeight--) {
                for(int leftWidth = 0; leftWidth < width; leftWidth++) {
                    for(int rightWidth = width - 1; rightWidth > 0; rightWidth--) {
                        if(upperHeight >= underHeight) continue;
                        if(leftWidth >= rightWidth) continue;
                        if(underHeight - upperHeight + 1 != rightWidth - leftWidth + 1) continue;
                        int upperLeft = map[upperHeight][leftWidth];
                        int underLeft = map[underHeight][leftWidth];
                        int underRight = map[underHeight][rightWidth];
                        int upperRight = map[upperHeight][rightWidth];
                        if(upperLeft == underLeft && upperLeft == upperRight && upperLeft == underRight) {
                            maxHeight = Math.max(underHeight - upperHeight + 1, maxHeight);
                            maxWidth = Math.max(rightWidth - leftWidth + 1, maxWidth);
                        }
                    }
                }
            }
        }
        answer = maxHeight * maxWidth;
        return answer;
    }
}

public class Problem_1051 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] sizeNum = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        int[][] map = new int[sizeNum[0]][sizeNum[1]];
        for(int i = 0; i < sizeNum[0]; i++) {
            map[i] = Pattern.compile("").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        }
        System.out.println(new Solution_1051(sizeNum[0], sizeNum[1], map).getAnswer());

    }
}
