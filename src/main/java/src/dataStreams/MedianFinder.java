package src.dataStreams;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianFinder {

    public static void main(String[] args) {
        MedianFinder finder = new MedianFinder();
        finder.addNum(1);
        System.out.println(finder.findMedian());
        finder.addNum(2);
        System.out.println(finder.findMedian());
        finder.addNum(3);
        System.out.println(finder.findMedian());
        finder.addNum(4);
        System.out.println(finder.findMedian());
        finder.addNum(5);
        System.out.println(finder.findMedian());
    }

    private PriorityQueue<Integer> minHeap;
    private PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        this.minHeap = new PriorityQueue<>();
        this.maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(num);
            return;
        }
        if (maxHeap.size() > minHeap.size()) {
            minHeap.add(num);
            if (minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
        } else {
            maxHeap.add(num);
            if (minHeap.peek() < maxHeap.peek()) {
                int temp = minHeap.poll();
                minHeap.add(maxHeap.poll());
                maxHeap.add(temp);
            }
        }
    }

    public double findMedian() {
        return (maxHeap.size() + minHeap.size())%2==0 ? (minHeap.peek() + maxHeap.peek())/2.0 : maxHeap.peek();
    }
}
