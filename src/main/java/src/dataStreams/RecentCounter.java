package src.dataStreams;

import java.util.LinkedList;
import java.util.Queue;

public class RecentCounter {
    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        System.out.println(rc.ping(1));
        System.out.println(rc.ping(100));
        System.out.println(rc.ping(3001));
        System.out.println(rc.ping(3002));
    }

    private static final int k = 3000;
    private Queue<Integer> qu;

    public RecentCounter() {
        this.qu = new LinkedList<>();
    }

    public int ping(int t) {
        qu.offer(t);
        while (t-qu.peek()>k) {
            qu.poll();
        }
        return qu.size();
    }
}
