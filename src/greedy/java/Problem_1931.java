package greedy.java;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Time {
    final int start;
    final int end;

    Time(int start, int end) {
        this.start = start;
        this.end = end;
    }
}


class Solution_1931 {
    private final int cases;
    private final ArrayList<Time> inputs;

    Solution_1931(int cases, ArrayList<Time> inputs) {
        this.cases = cases;
        this.inputs = inputs;
        final Comparator<Time> compareFunc = (a,b) -> {
             return Integer.compare(a.end, b.end) != 0 ? Integer.compare(a.end, b.end) : Integer.compare(a.start, b.start);
        };

        inputs.sort(compareFunc);
    }

    public int getAnswer() {
        int answer = 0;
        int endMax = 0;
        for(int i = 0; i < inputs.size(); i++) {
            if(endMax > inputs.get(i).start)
                continue;
            endMax = inputs.get(i).end;
            answer++;
        }
        return answer;
    }
}

public class Problem_1931 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int cases = Integer.parseInt(reader.readLine());
        ArrayList<Time>inputs = new ArrayList<>();
        for(int i = 1; i <= cases; i++) {
            int[] tmp = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
            inputs.add(new Time(tmp[0], tmp[1]));
        }
        System.out.println(new Solution_1931(cases, inputs).getAnswer());
    }
}
