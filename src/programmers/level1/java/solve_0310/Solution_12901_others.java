package programmers.level1.java.solve_0310;
import java.util.*;
public class Solution_12901_others {
    public String getDayName(int month, int day) {
        Calendar cal = new Calendar.Builder().setCalendarType("iso8601")
                .setDate(2016, month - 1, day).build();
        return cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.SHORT, new Locale("ko-KR")).toUpperCase();
    }

    public static void main(String[] args) {
        Solution_12901_others test = new Solution_12901_others();
        int a = 5, b = 24;
        System.out.println(test.getDayName(a, b));
    }
}
