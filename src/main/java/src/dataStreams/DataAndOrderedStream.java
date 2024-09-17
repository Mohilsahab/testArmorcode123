package src.dataStreams;

import java.util.ArrayList;
import java.util.List;

public class DataAndOrderedStream {
    public static void main(String[] args) {
        DataAndOrderedStream stream = new DataAndOrderedStream(5);
        System.out.println(stream.insert(3, "c"));
        System.out.println(stream.insert(1, "a"));
        System.out.println(stream.insert(2, "b"));
        System.out.println(stream.insert(5, "e"));
        System.out.println(stream.insert(4, "d"));
    }

    private String []str;
    private int ptr;

    public DataAndOrderedStream(int n) {
        this.str = new String[n];
        this.ptr = 0;
    }

    public List<String> insert(int idKey, String value) {
        List<String> res = new ArrayList<>();
        str[idKey-1] = value;
        while (ptr<str.length && str[ptr]!= null) {
            res.add(str[ptr]);
            ptr++;
        }
        return res;
    }
}
