package programmers.level1.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

public class Solution_12915 {
    public String[] solution(String[] strings, int n) {
        Comparator<String> comp = (String a, String b) -> {
            int compare = a.charAt(n) - b.charAt(n);
            if(compare != 0) return compare;
            else return a.compareTo(b);
        };
        String[] answer = new String[strings.length];
        answer = Arrays.stream(strings).sorted(comp).collect(Collectors.toList()).toArray(answer);
        return answer;
    }

    public static void main(String[] args) {
        Solution_12915 test = new Solution_12915();
        System.out.println(test.solution(new String[]{"sun", "bed", "car"}, 1));
    }
}
