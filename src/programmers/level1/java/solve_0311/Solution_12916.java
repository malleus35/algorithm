package programmers.level1.java.solve_0311;

public class Solution_12916 {
    boolean solution(String s) {
        String[] tmp = s.toLowerCase().split("");
        int numP = 0;
        int numY = 0;
        for(String word : tmp) {
            if(word.equals("p")) numP++;
            else if(word.equals("y")) numY++;
        }
        return numP == numY;
    }
}
