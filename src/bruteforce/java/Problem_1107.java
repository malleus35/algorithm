package bruteforce.java;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Solution_1107 {
    private final int input;
    private final int numOfBroken;
    private final int[] listOfBroken;
    private final boolean[] isBroken;
    private final ArrayList<Integer> makeNum;

    Solution_1107(int input, int numOfBroken, int[] listOfBroken) {
        this.input = input;
        this.numOfBroken = numOfBroken;
        this.listOfBroken = listOfBroken;
        this.isBroken = new boolean[10];
        this.makeNum = new ArrayList<>();

        for (int i = 0; i < numOfBroken; i++) {
            isBroken[listOfBroken[i]] = true;
        }
    }

    public int getAnswer() {
        int answer = 0;
        /*
        case
        0.  100이 나온 경우
        1.  100에서 단순히 +,- 하는게 제일 작은 경우 ex) 99 -> - -> 1, ex2) 100 -> 0
        2.  같은자리수 채널을 누르고 +,- 하는게 제일 작은 경우 input : 5457, brokenNum : 6 7 8, 5455 -> + -> +. -> 6
        3.  한자리 큰 자리수 채널을 누르고 +,- 하는게 제일 작은 경우 -> input : 999, brokenNum: 9 , 1000 -> - -> 5
        4.  한자리 작은 자리수 채널을 누르고 +,- 하는게 제일 작은 경우 ex) input : 1001, brokenNum: 0,1 , 999 -> + -> +. 5
        answer = Math.min(case 0, case 1, case 2, case 3, case 4)
        logic
        case 0. 100이면 0 리턴
            case 1. |input - 100| 을 구함
            case 2. input을 배열로 쪼갬 -> 가장큰 자리수부터 순회하면서 현재 값이랑 절대값의 차이가 가장 작은 수를 선택 -> 끝까지 반복 -> int로 같은 자리수 숫자로 만듬 ->  자리수 + |input - 만든수|
            case 3. input을 배열로 쪼갬 -> 해당하는 수와 가장 가까운 자리수가 차이나는 가장 작은 수를 만듬 -> ex) 5457 -> 10000. -> int로 같은 자리수 숫자로 만듬 ->  자리수 + |input - 만든수|
            case 4. input을 배열로 쪼갬 -> 해당하는 수와 가장 가까운 자리수가 차이나는 가장 큰 수를 만듬 -> ex) 5457 -> 999 -> int로 같은 자리수 숫자로 만듬 ->  자리수 + |input - 만든수|
         */

        if (input == 100) answer = 0;
        else {
            answer = Math.abs(input - 100);
            int[] inputArr = Pattern.compile("").splitAsStream(Integer.toString(input)).mapToInt(Integer::parseInt).toArray();
            int inputLen = inputArr.length;

            for (int i = 0; i < inputLen; i++) {
                for (int j = 0; j < 10; j++) {
                    int lowerNum = Math.abs(inputArr[i] - j);
                    int higherNum = Math.abs(inputArr[i] + j);
                    System.out.println("lower : " + lowerNum);
                    System.out.println("higher : " + higherNum);
                    if (lowerNum >= 0 && !isBroken[lowerNum]) {
                        makeNum.add(lowerNum);
                        break;
                    } else if (higherNum <= 9 && !isBroken[higherNum]) {
                        makeNum.add(higherNum);
                        break;
                    }
                }
            }
            String tmp = "";
            for (int i : makeNum) {
                tmp += i;
            }
            int tmp2 = 987654321;
            if (!tmp.equals(""))
                tmp2 = makeNum.size() + Math.abs(input - Integer.parseInt(tmp));
            System.out.println("tmp2 : " + tmp2);
            System.out.println("answer : " + answer);
            answer = Math.min(answer, tmp2);
            System.out.println("answer : " + answer);

            makeNum.clear();

            for (int i = 0; i < inputLen + 1; i++) {
                for (int j = 0; j < 10; j++) {
                    if (i == 0 && j == 0) continue;
                    if (!isBroken[j]) {
                        makeNum.add(j);
                        break;
                    }
                }
            }
            tmp = "";
            for (int i : makeNum) {
                tmp += i;
            }
            tmp2 = 987654321;
            if (!tmp.equals(""))
                tmp2 = makeNum.size() + Math.abs(input - Integer.parseInt(tmp));
//                answer = Math.min(answer, tmp2);
            System.out.println("tmp2 : " + tmp2);
            System.out.println("answer : " + answer);
            answer = Math.min(answer, tmp2);
            System.out.println("answer : " + answer);


            makeNum.clear();

            if (inputLen != 1) {
                for (int i = 0; i < inputLen - 1; i++) {
                    for (int j = 9; j >= 0; j--) {
                        if (i == 0 && j == 0) continue;
                        if (!isBroken[j]) {
                            makeNum.add(j);
                            break;
                        }
                    }
                }
            } else {
                for (int j = 9; j >= 0; j--) {
                    if (!isBroken[j]) {
                        makeNum.add(j);
                        break;
                    }
                }
            }

            tmp = "";
            for (int i : makeNum) {
                tmp += i;
            }
            tmp2 = 987654321;
            if (!tmp.equals(""))
                tmp2 = makeNum.size() + Math.abs(input - Integer.parseInt(tmp));
//            answer = Math.min(answer, tmp2);
            System.out.println("tmp2 : " + tmp2);
            System.out.println("answer : " + answer);
            answer = Math.min(answer, tmp2);
            System.out.println("answer : " + answer);

        }

        return answer;
    }
}

public class Problem_1107 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input = Integer.parseInt(reader.readLine());
        int numOfBroken = Integer.parseInt(reader.readLine());
        int[] listOfBroken = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        System.out.println(new Solution_1107(input, numOfBroken, listOfBroken).getAnswer());
    }
}
