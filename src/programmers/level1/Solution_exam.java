package programmers.level1;

import java.util.*;

public class Solution_exam {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[][] studentsAnswers = {{1, 2, 3, 4, 5}, {2, 1, 2, 3, 2, 4, 2, 5}, {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        int[] numOfCorrectProblems = new int[3];
        int[] moduloAnswers = {5, 8, 10};
        int numOfProblems = answers.length;
        for (int problem = 0; problem < numOfProblems; problem++) {
            for (int student = 0; student < 3; student++) {
                if (studentsAnswers[student][problem % moduloAnswers[student]] == answers[problem])
                    numOfCorrectProblems[student]++;
            }
        }
        int maxAnswers = Arrays.stream(numOfCorrectProblems).max().getAsInt();
        for (int student = 0; student < 3; student++) {
            if (maxAnswers == numOfCorrectProblems[student])
                answer.add(student + 1);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}
