//package src.dataStreams;
//
//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class StreamChecker {
//    public static void main(String[] args) {
////        String words[] = {"cd", "f", "kl"};
//        String words[] = {"ab","ba","aaab","abab","baa"};
//        StreamChecker checker = new StreamChecker(words);
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('b') + "  ");
//
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('b') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//        System.out.print(checker.query('a') + "  ");
//
//    }
//
//    @Getter
//    @NoArgsConstructor
//    private static class TrieNode {
//        private char value;
//        @Setter
//        private boolean isWord = false;
//        private List<TrieNode> nodes;
//    }
//
//    public TrieNode head;
//    private List<Character> stream;
//    public StreamChecker(String[] words) {
//        this.head = new TrieNode();
//        this.stream = new ArrayList<>();
//        for (String word : words) {
//            for(int i=word.length()-1; i>=0; i--) {
//                List<TrieNode> nodes = head.getNodes() == null ? new ArrayList<>() : head.getNodes();
//                for (TrieNode node : nodes) {
//                    if (node.value==word.charAt(i)) {
//
//                    }
//                }
//            }
//        }
//    }
//
//    public boolean query(char letter) {
//
//    }
//}
