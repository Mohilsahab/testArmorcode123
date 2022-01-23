package src.leetcode.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {
    public static void main(String[] args) {
//        String strs[] = {"eat","tea","tan","ate","nat","bat"};//[["bat"],["nat","tan"],["ate","eat","tea"]]
//        String strs[] = {"a"};//[["a"]]
        String strs[] = {"hhhhu","tttti","tttit","hhhuh","hhuhh","tittt"};//[[""]]
        List<List<String>> ans = new GroupAnagrams().groupAnagrams(strs);
        for (List<String> list : ans) {
            System.out.print("[");
            for (String str : list) {
                System.out.print(str+",");
            }
            System.out.println("]");
        }
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null) {
            return new ArrayList<>();
        }
        Map<String, List<String>> mp = new HashMap<>();
        for (String str : strs) {
            int[] chars = new int[26];
            for (int i=0; i<str.length(); i++) {
                chars[str.charAt(i) - 'a']++;
            }
            StringBuilder temp = new StringBuilder();
            for (int i=0; i<chars.length; i++) {
                temp.append("#").append(chars[i]);
            }
            if (!mp.containsKey(temp.toString())) {
                mp.put(temp.toString(), new ArrayList<>());
            }
            mp.get(temp.toString()).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> values : mp.values()) {
            ans.add(values);
        }
        return ans;
    }
}
