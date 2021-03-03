package bruteforce;

import java.util.*;
import java.io.*;
import java.util.regex.*;

class Solution_2798 {
    private final int n;
    private final int m;
    private final int[] cards;

    Solution_2798(int n, int m, int[] cards) {
        this.n = n;
        this.m = m;
        this.cards = cards;
    }

    public int getAnswer() {
        int optimisticSum = 0;
        int cardsLength = cards.length;
        for(int i = 0; i < cardsLength; i++) {
            for(int j = 0; j < cardsLength; j++) {
                if(j == i) continue;
                for(int k = 0; k < cardsLength; k++) {
                    if(k == i) continue;
                    if(k == j) continue;
                    int cardsSum = cards[i] + cards[j] + cards[k];
                    if(cardsSum > optimisticSum && cardsSum <= m) {
                        optimisticSum = cardsSum;
                    }
                    if(optimisticSum == m) return optimisticSum;
                }
            }
        }
        return optimisticSum;
    }
}

public class Problem_2798 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        int[] cards = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solution_2798(nAndM[0], nAndM[1], cards).getAnswer());
    }
}
