package bruteforce.java.backtrack;

import java.io.*;
import java.util.*;

/*
    중복되는 수가 들어갈 때는 isChecked와 같은 배열을 만들어서 검증할 것 (arrList.contains은 문제가 생김)
    백트래킹의 최종 결과를 리턴할 때 중복 검증 로직을 넣을 것
    중복검증 방식을 contains로 하니까 시간 초과가 남.
    중복 제거를 위해서는 set을 사용한다 -> TreeSet 사용 -> 틀림 (입력 대로 넣어야 하는데 아스키코드 값으로 재정렬을 해서 틀림)
    HashSet은 정렬을 안하고 무작위로 뱉어버려서 틀림
    LinkedHashSet으로 하니 정답
 */
class Solution_15663 {
    private final int n;
    private final int m;
    private final int[] inputNums;
    private final boolean[] isChecked;
    private final StringBuilder builder = new StringBuilder();
    private final LinkedHashSet<String> set = new LinkedHashSet<>();
    private final ArrayList<Integer> nums = new ArrayList<>();

    Solution_15663(int[] nAndM, int[] inputNums) {
        this.n = nAndM[0];
        this.m = nAndM[1];
        this.inputNums = inputNums;
        this.isChecked = new boolean[n];
    }

    private void backTrack(int depth) {
        if(depth == m) {
            StringBuilder verifyDuplication = new StringBuilder();
            for(int i : nums) {
                verifyDuplication.append(i).append(" ");
            }
            verifyDuplication.append("\n");
            set.add(verifyDuplication.toString());
            return;
        }

        for(int i = 0; i < n; i++) {
            if(isChecked[i]) continue;
            nums.add(inputNums[i]);
            isChecked[i] = true;
            backTrack(depth + 1);
            isChecked[i] = false;
            nums.remove(depth);
        }
    }

    public String getAnswer() {
        backTrack(0);
        for(String i : set) {
            builder.append(i);
        }
        return builder.toString();
    }
}

public class Problem_15663 {
    public static int[] getIntArrToString(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    public static int[] getSortedIntArrToString(String input) {
        return Arrays.stream(input.split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nAndM = getIntArrToString(reader.readLine());
        int[] inputNums = getSortedIntArrToString(reader.readLine());
        System.out.print(new Solution_15663(nAndM, inputNums).getAnswer());
    }
}
