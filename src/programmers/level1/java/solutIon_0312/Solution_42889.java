package programmers.level1.java.solutIon_0312;
import java.util.*;
import java.util.stream.*;
public class Solution_42889 {
    private class Stage {
        private final int stage;
        private final double prob;

        Stage(int stage, double prob) {
            this.stage = stage;
            this.prob = prob;
        }
    }
    public int[] solution(int N, int[] stages) {
        ArrayList<Stage> failProb = new ArrayList<>();
        for(int i = 1; i <= N; i++) {
            int finalI = i;
            int fails = (int) Arrays.stream(stages).filter(e -> e == finalI).count();
            int finalI1 = i;
            int clears = (int) Arrays.stream(stages).filter(e -> e >= finalI1).count();
            double prob = 0;
            if(clears == 0) {
                prob = 1;
                if(fails == 0) prob = 0;
            } else prob = (double) fails / clears;
            failProb.add(new Stage(i, prob));
        }
        Comparator<Stage> comp = (a, b) -> {
            if(a.prob == b.prob) {
                return a.stage - b.stage;
            } else {
                if(a.prob > b.prob) return -1;
                else return 1;
            }
        };
        failProb.sort(comp);
        int[] answer = new int[N];
        for(int i = 0; i < N; i++) {
            answer[i] = failProb.get(i).stage;
        }
        return answer;
    }
}
