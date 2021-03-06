package programmers.level1.java;

import java.util.*;

public class Solution_uncompletion {
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, ArrayList<String>> hash = new HashMap<>();

        for (String person : completion) {
            if (hash.get(person) != null) {
                hash.get(person).add(person);
            } else {
                ArrayList<String> tmp = new ArrayList<>();
                tmp.add(person);
                hash.put(person, tmp);
            }
        }

        for (String person : participant) {
            if (hash.get(person) == null) {
                answer = person;
                break;
            } else if (hash.get(person).size() == 0) {
                answer = person;
                break;
            } else {
                int size = hash.get(person).size();
                hash.get(person).remove(size - 1);
            }
        }
        return answer;
    }
}
