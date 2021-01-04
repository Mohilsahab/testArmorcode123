package src.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Test6 {

//    Given a collection of intervals , merge all overlapping intervals
//    i/p : [[1,3],[2,6],[8,10],[9,9],[15,18]]
//    o/p : [[1,6],[8,10],[15,18]]
    static class Interval {
        public int start;
        public int end;
    }

    public static void main(String args[]) {
        List<Interval> intervals = new ArrayList<>();
        intervals.add(getInterval(1,3));
        intervals.add(getInterval(2,6));
        intervals.add(getInterval(9,9));
        intervals.add(getInterval(8,10));
        intervals.add(getInterval(15,18));
        intervals.add(getInterval(3,3));
        intervals.add(getInterval(2,2));
        intervals.add(getInterval(-10, -2));

        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval interval, Interval interval2) {
                if (interval.start < interval2.start) {
                    return -1;
                } else if (interval.start == interval2.start) {
                    return 0;
                }
                return 1;
            }
        });

        List<Interval> outputIntervals = new ArrayList<>();
        outputIntervals.add(intervals.get(0));
        int index = 0;
        Interval prevInterval, currInterval;
        for (int i=1; i<intervals.size(); i++) {
            prevInterval = outputIntervals.get(index);
            currInterval = intervals.get(i);
            if (prevInterval.end >= currInterval.start) {
                prevInterval.end = Math.max(currInterval.end, prevInterval.end);
                outputIntervals.remove(index);
                outputIntervals.add(prevInterval);
            } else {
                index++;
                outputIntervals.add(currInterval);
            }
        }

        for (Interval interval : outputIntervals) {
            System.out.println(interval.start  + " , " + interval.end);
        }
    }

    private static Interval getInterval(int start, int end) {
        Interval interval = new Interval();
        interval.start = start;
        interval.end = end;
        return interval;
    }
}