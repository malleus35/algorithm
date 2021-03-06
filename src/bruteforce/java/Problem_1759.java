package bruteforce.java;

import java.io.*;
import java.util.regex.*;
import java.util.stream.Collectors;

class Solution_1759 {
    private final int l;
    private final int c;
    private final String[] letters;
    private final String[] pwd;

    Solution_1759(int l, int c, String[] letters) {
        this.l = l;
        this.c = c;
        this.letters = letters;
        this.pwd = new String[l];
    }

    private void backTrack(StringBuilder resultBuilder, int numOfCon, int numOfVow, int lastIndex, int depth) {
        if(depth == l) {
            if(numOfCon >= 2 && numOfVow >= 1) {
                for(int i = 0; i < l; i++) {
                    resultBuilder.append(pwd[i]);
                }
                resultBuilder.append("\n");
            }
            return;
        }
        for(int i = lastIndex+1; i < c; i++) {
            pwd[depth] = letters[i];
            if(("aeiou").contains(letters[i])) {
                backTrack(resultBuilder, numOfCon, numOfVow + 1, i, depth + 1);
            } else {
                backTrack(resultBuilder, numOfCon + 1, numOfVow, i, depth + 1);
            }
            pwd[depth] = "";
        }
    }

    public String getAnswer() {
        StringBuilder resultBuilder = new StringBuilder();
        backTrack(resultBuilder, 0,0, -1, 0);
        return resultBuilder.toString();
    }
}

public class Problem_1759 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] LAndC = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        String[] letters = Pattern.compile(" ").splitAsStream(reader.readLine()).sorted().collect(Collectors.toList()).toArray(new String[LAndC[1]]);;
        System.out.println(new Solution_1759(LAndC[0], LAndC[1], letters).getAnswer());
    }
}
