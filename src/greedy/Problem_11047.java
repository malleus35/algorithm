package greedy;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_11047 {
    private final int numOfCoins;
    private final int cost;
    private final int[] coins;

    Solution_11047(int numOfCoins, int cost, int[] coins) {
        this.numOfCoins = numOfCoins;
        this.cost = cost;
        this.coins = coins;
    }

    public int getAnswer() {
        int answer = 0;
        int presentCost = cost;
        for(int i = numOfCoins; i >= 1; i--) {
            if(coins[i] > presentCost) continue;
            else {
                answer += presentCost / coins[i];
                presentCost = presentCost % coins[i];
            }
        }
        return answer;
    }
}

public class Problem_11047 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] numOfCoins = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        int[] coins = new int[numOfCoins[0] + 1];
        for(int i = 1; i <= numOfCoins[0]; i++) {
            coins[i] = Integer.parseInt(reader.readLine());
        }
        System.out.println(new Solution_11047(numOfCoins[0], numOfCoins[1], coins).getAnswer());
    }
}
