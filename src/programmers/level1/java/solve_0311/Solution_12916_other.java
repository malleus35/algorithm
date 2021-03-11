package programmers.level1.java.solve_0311;

public class Solution_12916_other {
    public boolean solution(String s) {
        s = s.toUpperCase();

        return s.chars().filter( e -> 'P'== e).count() == s.chars().filter( e -> 'Y'== e).count();
    }
}
