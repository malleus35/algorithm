package programmers.level1.java.solve_0311;

public class Solution_12940 {
    public int[] solution(int n, int m) {
        int[] answer = new int[2];
        answer[0] = gcd(n,m);
        answer[1] = lcm(n,m);
        return answer;
    }

    private int gcd(int a, int b) {
        int larger = Math.max(a,b);
        int smaller = Math.min(a,b);
        if(larger % smaller == 0) return smaller;
        while(larger % smaller != 0) {
            int mod = larger % smaller;
            larger = smaller;
            smaller = mod;
        }
        return smaller;
    }

    private int lcm(int a, int b) {
        return (a / gcd(a,b)) * b;
    }
}
