package programmers.level1.java;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution_72410 {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = Arrays.stream(answer.split("")).filter(e -> !"~!@#$%^&*()=+[{]}:?,<>/".contains(e)).collect(Collectors.joining());
        answer = answer.replaceAll("(\\.){2,}","\\.");
        String finalAnswer = "";

        for(int i = 0; i < answer.length(); i++) {
            if((i == 0 || i == answer.length() - 1) && answer.charAt(i) == '.') {
                finalAnswer+="";
            } else finalAnswer += answer.charAt(i);
        }
        answer = finalAnswer;
//        answer = Arrays.stream(answer.split("")).map(e -> {
//            int tIndex = finalAnswer.indexOf(e);
//            if((tIndex == 0 || tIndex == finalAnswer.length() - 1) && e.equals(".")) return "";
//            else return e;
//        }).collect(Collectors.joining());
        answer = answer.equals("") ? "a" : answer;
        answer = Arrays.stream(answer.split("")).limit(15).collect(Collectors.joining());
        answer = answer.charAt(answer.length() - 1) == '.' ? answer.substring(0, answer.length() - 1) : answer;
        if(answer.length() <= 2) {
            int len = answer.length();
            char last = answer.charAt(len - 1);
            while(len < 3) {
                answer += last;
                len++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(new Solution_72410().solution(	"...!@BaT#*..y.abcdefghijklm"));
    }
}
