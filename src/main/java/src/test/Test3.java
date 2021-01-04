package src.test;

public class Test3 {
    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("cdabefabgh");
        int index = str.lastIndexOf("ab");
        System.out.println(index);
        str.delete(index, str.length());
        System.out.println(str.toString());
    }
}