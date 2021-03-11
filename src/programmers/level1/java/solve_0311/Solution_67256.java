package programmers.level1.java.solve_0311;

import java.util.HashMap;

public class Solution_67256 {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        HashMap<Integer, int[]> hash = new HashMap<>();
        setHash(hash);
        int leftPos = -1;
        int rightPos = -2;
        for(int i : numbers) {
            if(i % 3 == 1) {
                answer.append("L");
                leftPos = i;
            }
            else if(i != 0 && i % 3 == 0) {
                answer.append("R");
                rightPos = i;
            }
            else {
                if(hash.get(leftPos)[i] < hash.get(rightPos)[i]) {
                    answer.append("L");
                    leftPos = i;
                } else if (hash.get(leftPos)[i] > hash.get(rightPos)[i]) {
                    answer.append("R");
                    rightPos = i;
                } else {
                    if(hand.equals("left")) {
                        answer.append("L");
                        leftPos = i;
                    } else if(hand.equals("right")) {
                        answer.append("R");
                        rightPos = i;
                    }
                }
            }
        }
        return answer.toString();
    }

    private void setHash(HashMap<Integer, int[]> hash) {
        for (int i = -2; i <= 9; i++) {
            int[] tmp = new int[10];
            switch (i) {
                case -2:
                case -1:
                    tmp[2] = 4;
                    tmp[5] = 3;
                    tmp[8] = 2;
                    tmp[0] = 1;
                    hash.put(i, tmp);
                    break;
                case 0:
                    tmp[1] = 4;
                    tmp[3] = 4;

                    tmp[4] = 3;
                    tmp[6] = 3;

                    tmp[7] = 2;
                    tmp[9] = 2;

                    tmp[2] = 3;
                    tmp[5] = 2;
                    tmp[8] = 1;
                    hash.put(i, tmp);
                    break;
                case 1:
                case 3:
                    tmp[2] = 1;
                    tmp[5] = 2;
                    tmp[8] = 3;
                    tmp[0] = 4;
                    hash.put(i, tmp);
                    break;
                case 4:
                case 6:
                    tmp[2] = 2;
                    tmp[5] = 1;
                    tmp[8] = 2;
                    tmp[0] = 3;
                    hash.put(i, tmp);
                    break;
                case 7:
                case 9:
                    tmp[2] = 3;
                    tmp[5] = 2;
                    tmp[8] = 1;
                    tmp[0] = 2;
                    hash.put(i, tmp);
                    break;
                case 2:
                    tmp[1] = 1;
                    tmp[3] = 1;

                    tmp[4] = 2;
                    tmp[6] = 2;

                    tmp[7] = 3;
                    tmp[9] = 3;

                    tmp[0] = 3;
                    tmp[5] = 1;
                    tmp[8] = 2;
                    hash.put(i, tmp);
                    break;
                case 5:
                    tmp[1] = 2;
                    tmp[3] = 2;

                    tmp[4] = 1;
                    tmp[6] = 1;

                    tmp[7] = 2;
                    tmp[9] = 2;

                    tmp[0] = 2;
                    tmp[2] = 1;
                    tmp[8] = 1;
                    hash.put(i, tmp);
                    break;
                case 8:
                    tmp[1] = 3;
                    tmp[3] = 3;

                    tmp[4] = 2;
                    tmp[6] = 2;

                    tmp[7] = 1;
                    tmp[9] = 1;

                    tmp[0] = 1;
                    tmp[2] = 2;
                    tmp[5] = 1;
                    hash.put(i, tmp);
                    break;
            }
        }
    }
}
