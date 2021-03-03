package greedy;

import java.io.*;
import java.util.*;
import java.util.regex.*;

class Killee {
    public final int dmg;
    public final int order;

    Killee(int dmg, int order) {
        this.dmg = dmg;
        this.order = order;
    }

    public int getDmg() {
        return dmg;
    }
}

class HealItem {
    public final int value;
    public final int order;

    HealItem(int value, int order) {
        this.value = value;
        this.order = order;
    }

    public int getValue() {
        return value;
    }
}

class Solution_19639 {
    private final int[] inputs;
    private final Killee[] toKills;
    private final HealItem[] toHeals;

    Solution_19639(int[] inputs, Killee[] toKills, HealItem[] toHeals) {
        this.inputs = inputs;
        this.toKills = toKills;
        this.toHeals = toHeals;
        final Comparator<Killee> killeeComparator = Comparator.comparingInt(Killee::getDmg);
        final Comparator<HealItem> comparator = Comparator.comparingInt(HealItem::getValue);
        Arrays.sort(this.toKills, killeeComparator);
        Arrays.sort(this.toHeals, comparator);
    }

    public String getAnswer() {
        StringBuilder builder = new StringBuilder();
        int killLen = inputs[0];
        int healLen = inputs[1];
        int maxHP = inputs[2];

        int presentKill = 1;
        int presentHeal = 1;
        int presentHP = maxHP;
        boolean isAllKill = false;
        boolean isAllHeal = false;

        while(!isAllKill || !isAllHeal) {
            if(!isAllKill) {
                if(presentKill > killLen) {
                    isAllKill = true;
                    continue;
                }
                if(presentHP - toKills[presentKill].dmg > 0) {
                    presentHP -= toKills[presentKill].dmg;
                    builder.append("-").append(toKills[presentKill++].order).append("\n");
                    if(presentKill > killLen) isAllKill = true;
                } else {
                    if(!isAllHeal) {
                        if(presentHeal > healLen) {
                            isAllHeal = true;
                            continue;
                        }
                        if (presentHP + toHeals[presentHeal].value > maxHP)
                            presentHP = maxHP;
                        else presentHP += toHeals[presentHeal].value;
                        builder.append(toHeals[presentHeal++].order).append("\n");
                    } else {
                        return "0";
                    }
                }
            } else {
                if(!isAllHeal) {
                    if(presentHeal > healLen) {
                        isAllHeal = true;
                        continue;
                    }
                    builder.append(toHeals[presentHeal++].order).append("\n");
                }
            }
        }
        return builder.toString();
    }
}

public class Problem_19639 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] inputs = Pattern.compile(" ").splitAsStream(reader.readLine()).mapToInt(Integer::parseInt).toArray();
        Killee[] toKills = new Killee[inputs[0] + 1];
        HealItem[] toHeals = new HealItem[inputs[1] + 1];

        toKills[0] = new Killee(0,0);
        toHeals[0] = new HealItem(0,0);

        for(int i = 1; i <= inputs[0]; i++) {
            toKills[i] = new Killee(Integer.parseInt(reader.readLine()), i);
        }

        for(int j = 1; j <= inputs[1]; j++) {
            toHeals[j] = new HealItem(Integer.parseInt(reader.readLine()), j);
        }

        System.out.println(new Solution_19639(inputs, toKills, toHeals).getAnswer());
    }
}
