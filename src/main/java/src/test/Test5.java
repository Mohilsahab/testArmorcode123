package src.test;


public class Test5 {

    public static void main(String[] args) {
        String str = "Z";
        int  value = getColNum(str);
        System.out.println(value);
    }

    private static int getColNum(String str) {
        int res = 1;
        for (int i=0; i<str.length(); i++) {
            res = ((res-1)*26 + (str.charAt(i)-'A'+1));
        }
        return res;
    }


}
