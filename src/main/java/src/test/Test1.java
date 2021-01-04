package src.test;

import java.util.HashMap;
import java.util.Map;

public class Test1 {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        System.out.println(new Test1().checkInclusion(s1,s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        if (s1 == null && s2 == null) {
            return true;
        } else if (s2 == null) {
            return false;
        } else if (s1 == null) {
            return true;
        }
        Map<Character, Integer> mp = new HashMap<>();
        for (int i=0; i<s1.length(); i++) {
            mp.put(s1.charAt(i), mp.getOrDefault(s1.charAt(i), 0) + 1);
        }

        Map<Character, Integer> temp = new HashMap<>(mp);
        int startIndex = 0;
        for (int i=0; i<s2.length(); i++) {
            Integer value = temp.get(s2.charAt(i));
            if (value != null) {
                if (value == 1) {
                    temp.remove(s2.charAt(i));
                    if (temp.size() == 0){
                        return true;
                    }
                } else {
                    temp.put(s1.charAt(i), value - 1);
                }
            } else {
                if (s2.charAt(i) == s2.charAt(startIndex)
                    && mp.containsKey(s2.charAt(i))) {
                    if (temp.size() == 0){
                        return true;
                    }
                    startIndex++;
                } else {
                    temp = new HashMap<>(mp);
                    startIndex++;
                }
            }
        }
        return false;
    }
}
