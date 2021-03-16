package bruteforce.java.backtrack;
import java.io.*;
import java.util.*;

/*
    Stream은 재활용이 안되니 명심 할 것
    정답은 맞는듯 하나 시간초과 -> set이나 map으로 시간 초과 방지해보기
 */
class Solution_1062 {
    private final int n;
    private final int k;
    private final ArrayList<String> inputWords;
    private final ArrayList<Character> availableChars = new ArrayList<>();
    private int answer = 0;
    private String[] restChars = "bdefghjklmopqrsuvwxyz".split("");

    Solution_1062(int[] nAndK, ArrayList<String> inputWords) {
        this.n = nAndK[0];
        this.k = nAndK[1];
        this.inputWords = inputWords;
        availableChars.add('a');
        availableChars.add('c');
        availableChars.add('i');
        availableChars.add('n');
        availableChars.add('t');
        //k + 5
    }

    private void backTrack(int depth) {
        if(depth == k) {
            int tmpAnswer = 0;
            for(String i : inputWords) {
                boolean isNoneMatch = false;
                for(char letter : i.toCharArray()) {
                    if(!availableChars.contains(letter)) {
                        isNoneMatch = true;
                    }
                }
                if(!isNoneMatch) tmpAnswer++;
                answer = Math.max(tmpAnswer, answer);
            }
            return;
        }
        for(int i = 0; i < 21; i++) {
            if(availableChars.contains(restChars[i].charAt(0))) continue;
            availableChars.add(restChars[i].charAt(0));
            backTrack(depth + 1);
            availableChars.remove(depth);
        }
    }

    public int getAnswer() {
        if(k < 5) return 0;
        backTrack(5);
        return answer;
    }
}

public class Problem_1062 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndK = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        ArrayList<String> words = new ArrayList<>();
        for(int n = 0; n < nAndK[0]; n++) {
            words.add(reader.readLine());
        }
        System.out.println(new Solution_1062(nAndK, words).getAnswer());
    }
}
