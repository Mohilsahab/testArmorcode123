package src.dataStreams;

import java.util.PriorityQueue;

public class KthLargestElement {

    public static void main(String[] args) {
        int k = 3;
        int nums[] = {4, 5, 8, 2};
        KthLargestElement kthLargestElement = new KthLargestElement(k ,nums);
        System.out.println(kthLargestElement.add(3));
        System.out.println(kthLargestElement.add(5));
        System.out.println(kthLargestElement.add(10));
        System.out.println(kthLargestElement.add(9));
        System.out.println(kthLargestElement.add(4));
    }

    private int k;
    private PriorityQueue<Integer> heap;

    public KthLargestElement(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for (int num : nums) {
            heap.add(num);
        }
        while (heap.size() > k) {
            heap.poll();
        }
    }

    public int add(int val) {
        heap.offer(val);
        while (heap.size() > k) {
            heap.poll();
        }
        return heap.peek();
    }
}
