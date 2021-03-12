package programmers.level1.java.solutIon_0312;

public class Solution_17681 {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        int[] bitArr = new int[n];
        String[] answer = new String[n];
        for(int i = 0; i < n; i++) {
            bitArr[i] = arr1[i] | arr2[i];
        }
        for(int i = 0; i < n; i++) {
            answer[i] = String.format("%"+n+"s",Integer.toBinaryString(bitArr[i])).replace(' ', '0').chars().map(e -> e == '1' ? '#' : ' ').collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        }
        return answer;
    }
}
