package src.leetcode.bfs;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        //NOTE: All words in input have same length
        int res = new WordLadder().ladderLength2("hit", "cog",
//                Arrays.asList("hot","dot","dog","lot","log"));
                Arrays.asList("hot","dot","dog","lot","log","cog"));
        System.out.println(res);
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);

        int count = 0;
        int size;
        String currWord;
        while (!qu.isEmpty()) {
            size = qu.size();
            count++;
            while (size>0) {
                currWord = qu.poll();
                if (endWord.equals(currWord)) {
                    return count;
                }
                for (String word: getUnVisitedWords(wordList, currWord, visited)) {
                    qu.add(word);
                }
                size--;
            }
        }
        return 0;
    }

    private Set<String> getUnVisitedWords(List<String> wordList, String currWord, Set<String> visited) {
        Set<String> unVisitedWords = new HashSet<>();
        for (String word : wordList) {
            if (!visited.contains(word)
                   && oneCharDiff(word, currWord)) {
                visited.add(word);
                unVisitedWords.add(word);
            }
        }
        return unVisitedWords;
    }

    private boolean oneCharDiff(String word1, String word2) {
        int countDiff = 0;
        for (int i=0; i<word1.length() && countDiff<2; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                countDiff++;
            }
        }
        return countDiff<2;
    }

    public int ladderLength2(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet(wordList);
        Set<String> visited = new HashSet<>();
        Queue<String> qu = new LinkedList<>();
        qu.add(beginWord);

        int count = 0;
        int size;
        String currWord;
        while (!qu.isEmpty()) {
            size = qu.size();
            count++;
            while (size-->0) {
                currWord = qu.poll();
                if (endWord.equals(currWord)) {
                    return count;
                }
                for(int i = 0; i < currWord.length(); i++) { // for each characters of word
                    for(char c = 'a'; c <= 'z'; c++) { // replace with a-z
                        String newWord = currWord.substring(0, i) + c + currWord.substring(i + 1);
                        if(wordSet.contains(newWord) && !visited.contains(newWord)) { // check if newWrod is in wordSet and not visited
                            qu.add(newWord); // add in queue
                            visited.add(newWord); // mark visited
                        }
                    }
                }
            }
        }
        return 0;
    }
}