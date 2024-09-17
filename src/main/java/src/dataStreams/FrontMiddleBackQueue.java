package src.dataStreams;

import java.util.ArrayList;
import java.util.List;

public class FrontMiddleBackQueue {

    private List<Integer> list;

    public FrontMiddleBackQueue() {
        this.list = new ArrayList<>();
    }

    public void pushFront(int val) {
        list.add(0, val);
    }

    public void pushMiddle(int val) {
        int mid = list.size()/2;
        list.add(mid, val);
    }

    public void pushBack(int val) {
        list.add(val);
    }

    public int popFront() {
        return list.size() ==0 ? -1 : list.remove(0);
    }

    public int popMiddle() {
        int size = list.size();
        if (size == 0) {
            return -1;
        }
        return size%2 == 0 ? list.remove(size/2-1) : list.remove(size/2);
    }

    public int popBack() {
        return list.size() ==0 ? -1 : list.remove(list.size()-1);
    }
}
