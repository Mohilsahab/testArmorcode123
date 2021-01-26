package src.leetcode.bfs;

import java.util.*;
import java.util.function.Predicate;

public class WordLadder2 {
    public static void main(String[] args) {
        List<List<String>> res = new WordLadder2().findLadders("hit", "cog",
                Arrays.asList("hot","dot","dog","lot","log")); // hit, cog
//                Arrays.asList("hot","dot","dog","lot","log","cog")); // hit, cog
//                Arrays.asList("ted","tex","red","tax","tad","den","rex","pee")); // red, tax
//                Arrays.asList("a", "b", "c")); // a, c
        System.out.println(res);
    }

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, Set<String>> wordMp = new HashMap<>();
        Set<String> wordSet = new HashSet(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);

        Set<String> addBegin = new LinkedHashSet<>();
        addBegin.add(beginWord);
        wordMp.put(beginWord, addBegin);

        int size;
        int count = 0;
        String currWord = null;
        while (!qu.isEmpty()) {
            size = qu.size();
            count++;
            while (size-->0) {
                currWord = qu.poll();
                if (visited.contains(currWord)) {
                    continue;
                }
                visited.add(currWord);
                if (endWord.equals(currWord)) {
                    break;
                }
                Set<String> resList = new HashSet<>();
                for(int i = 0; i < currWord.length(); i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        String newWord = currWord.substring(0, i) + c + currWord.substring(i + 1);
                        if(wordSet.contains(newWord) && !visited.contains(newWord)) {
                            resList.add(newWord);
                            qu.add(newWord);
                        }
                    }
                }
                wordMp.put(currWord, resList);
            }
            if (endWord.equals(currWord)) {
                break;
            }
        }
//        System.out.println(wordMp);
//        System.out.println(count);
        Map<String,Integer> v=new HashMap<>();
        List<List<String>> result = new ArrayList<>();
        List<String> tempList = new ArrayList<>();
        tempList.add(beginWord);
        dfs(result, tempList, beginWord, endWord, wordMp, count, v);
        return result;
    }

    private void dfs(List<List<String>> result, List<String> tempList,
                     String beginWord, String endWord, Map<String, Set<String>> wordMp, int count, Map<String,Integer> v) {
        if (count==1) {
            if (beginWord.equals(endWord)) {
                result.add(new ArrayList<>(tempList));
            }
            return;
        }
        v.put(beginWord, 1);
        for (String word : wordMp.get(beginWord))  {
            if (v.getOrDefault(word, 0) != 1) {
                tempList.add(word);
                dfs(result, tempList, word, endWord, wordMp, count - 1, v);
                tempList.remove(word);
            }
        }
        v.put(beginWord, 0);
    }

    /*public List<List<String>> findLadders2(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<Set<String>>> wordMp = new HashMap<>();
        Set<String> wordSet = new HashSet(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);
        visited.add(beginWord);

        List<Set<String>> list = new ArrayList<>();
        Set<String> addBegin = new LinkedHashSet<>();
        addBegin.add(beginWord);
        list.add(addBegin);
        wordMp.put(beginWord, list);

        int size;
        String currWord = null;
        boolean flag = false;
        while (!qu.isEmpty()) {
            size = qu.size();
            while (size-->0) {
                currWord = qu.poll();
                if (endWord.equals(currWord)) {
                    break;
                }
                List<Set<String>> resList = wordMp.getOrDefault(currWord, new ArrayList<>());
//                wordMp.remove(currWord);
                for(int i = 0; i < currWord.length(); i++) {
                    for(char c = 'a'; c <= 'z'; c++) {
                        String newWord = currWord.substring(0, i) + c + currWord.substring(i + 1);
                        if (newWord.equals(endWord)) {
                            flag = true;
                        }
                        if(wordSet.contains(newWord) && !visited.contains(newWord)) {
                            resList.add(newWord);
                            wordMp.put(newWord, new LinkedHashSet<>(resList));
                            resList.remove(newWord);
                            qu.add(newWord);
                            visited.add(newWord);
                        } else if (wordSet.contains(newWord) && newWord.equals(endWord)) {
                            resList.add(newWord);
                            wordMp.put(currWord, new LinkedHashSet<>(resList));
                            resList.remove(newWord);
                        }
                    }
                }
            }
            if (endWord.equals(currWord) || flag) {
                break;
            }
        }
        System.out.println(wordMp);
        List<List<String>> result = new ArrayList<>();
        wordMp.values().forEach((value) -> {
            if (value.contains(endWord)) {
                result.add(new ArrayList<>(value));
            }
        });
        return result;
    }*/
}
