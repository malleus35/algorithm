package programmers.level1.java.solve_0310;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_12926 {
    public String solution(String s, int n) {
        List<Character> letters = Arrays.stream("ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("")).map(e -> e.charAt(0)).collect(Collectors.toList());
        StringBuilder answer = new StringBuilder();
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                answer.append(' ');
                continue;
            }
            char nextLetter = letters.get((letters.indexOf(Character.toUpperCase(s.charAt(i))) + n) % 26);
            answer.append(Character.isUpperCase(s.charAt(i)) ? nextLetter : Character.toLowerCase(nextLetter));
        }
        return answer.toString();
    }
}
