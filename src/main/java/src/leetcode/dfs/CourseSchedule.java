package src.leetcode.dfs;

import java.util.*;

public class CourseSchedule {
    public static void main(String[] args) {

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> mp = new HashMap<>();
        Set<Integer> values = new HashSet<>();
        for (int i=0; i<prerequisites.length; i++) {
            Set<Integer> set = mp.getOrDefault(prerequisites[i][0], new HashSet<>());
            set.add(prerequisites[i][1]);
            values.add(prerequisites[i][1]);
            mp.put(prerequisites[i][0], set);
        }
        Queue<Integer> queue = new LinkedList<>();
        mp.forEach((key, value) -> {
            if (!values.contains(key)) {
                queue.add(key);
            }
        });
        Set<Integer> visited = new HashSet<>();
        Integer curr;
        while (!queue.isEmpty()) {
            curr = queue.poll();
            if (visited.contains(curr)) {
                return false;
            } else {
                visited.add(curr);
                if (mp.containsKey(curr)) {
                    mp.get(curr).forEach(value -> queue.add(value));
                }
            }
        }
        return true;
    }
}
