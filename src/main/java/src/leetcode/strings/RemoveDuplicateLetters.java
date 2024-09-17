package src.leetcode.strings;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicateLetters {
    public static void main(String[] args) {
        System.out.println(new RemoveDuplicateLetters().removeDuplicateLetters("cbacdcbc"));
    }

    public String removeDuplicateLetters(String s) {
        Set<Character> set = new LinkedHashSet<>();
        for (int i=0;i<s.length();i++) {
            set.add(s.charAt(i));
        }
        Iterator<Character> it = set.iterator();
        StringBuilder builder = new StringBuilder();
        while (it.hasNext()) {
            builder.append(it.next());
        }
        return builder.toString();
    }
}
