package greedy;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Competition {
    final int moneyLimit;
    final int money;

    Competition(int moneyLimit, int money) {
        this.moneyLimit = moneyLimit;
        this.money = money;
    }
}

class Solution_19582 {
    private final int len;
    private final Competition[] inputs;

    Solution_19582(int len, Competition[] inputs) {
        this.len = len;
        this.inputs = inputs;
    }

    public String getAnswer() {
        int answer = 0;
        int presentMoney = 0;
        int presentLimit = 0;
        int pastMoney = 0;
        int accumulator = 0;
        boolean isAlreadyNotIn = false;
        for (int i = 1; i <= len; i++) {
            presentMoney = inputs[i].money;
            presentLimit = inputs[i].moneyLimit;
            System.out.println("money : " + presentMoney);
            System.out.println("Limit : " + presentLimit);
            System.out.println("pastMoney : " + pastMoney);
            System.out.println("accu : " + accumulator);
            System.out.println("isAlready : "  + isAlreadyNotIn);
            System.out.println("answer : " + answer);
            if(presentLimit > accumulator) {
                answer++;
                accumulator += presentMoney;
                pastMoney = presentMoney;
            } else {
                System.out.println("test");
                if(!isAlreadyNotIn) isAlreadyNotIn = true;
                else break;
            }
        }
        return answer >= len - 1 ? "Kkeo-eok" : "Zzz";
    }
}

public class Problem_19582 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int len = Integer.parseInt(reader.readLine());
        Competition[] inputs = new Competition[len + 1];
        inputs[0] = new Competition(0,0);
        for(int i = 1; i <= len; i++) {
            int[] input = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
            inputs[i] = new Competition(input[0], input[1]);
        }
        System.out.println(new Solution_19582(len, inputs).getAnswer());
    }
}
