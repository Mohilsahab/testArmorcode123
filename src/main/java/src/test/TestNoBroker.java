package src.test;

import java.util.Stack;

public class TestNoBroker {
    //2+2/2*2

    public static void main(String[] args) {
        //4
        //
//      O(n)
        String a = "2+2/2*2";//O(4*n) ~ O(n)
        //"1000/223/456/678"
        int res = findComputation(a);
        System.out.println(res);
    }

    private static int findComputation(String s) {
        char res[] = new char[s.length()];
        int resIndex = 0;
        for (int i=0;i<s.length(); i++) {
            if (s.charAt(i) == '/') {
                int temp  = (res[resIndex-1] - 48)/(s.charAt(i+1)-48);
                res[resIndex-1] = (char)(temp + 48);
                i++;
            } else {
                res[resIndex] = s.charAt(i);
                resIndex++;
            }
        }
        return 0;
    }

    private static String getStringAfterDivision(String s) {
        if (!s.contains("/")) {
            return s;
        }
        char res[] = new char[s.length()];
        int resIndex = 0;
        for (int i=0;i<s.length(); i++) {
            if (s.charAt(i) == '/') {
                int temp  = (res[resIndex-1] - 48)/(s.charAt(i+1)-48);
                res[resIndex-1] = (char)(temp + 48);
                i++;
            } else {
                res[resIndex] = s.charAt(i);
                resIndex++;
            }
        }
        String temp = "";
        for (int i=0;i<resIndex;i++) {
            temp+=res[i];
        }
        return temp.trim();
    }

    private static String getStringAfterMultiplication(String dividionedString) {
        if (!dividionedString.contains("*")) {
            return dividionedString;
        }
        char res[] = new char[dividionedString.length()];
        int resIndex = 0;
        for (int i=0;i<dividionedString.length(); i++) {
            if (dividionedString.charAt(i) == '*') {
                int temp  = (res[resIndex-1] - 48)*(dividionedString.charAt(i+1)-48);
                res[resIndex-1] = (char)(temp + 48);
                i++;
            } else {
                res[resIndex] = dividionedString.charAt(i);
                resIndex++;
            }
        }
        String temp = "";
        for (int i=0;i<resIndex;i++) {
            temp+=res[i];
        }
        return temp.trim();
    }

    private static String getStringAfterAddition(String s) {
        if (!s.contains("+")) {
            return s;
        }
        char res[] = new char[s.length()];
        int resIndex = 0;
        for (int i=0;i<s.length(); i++) {
            if (s.charAt(i) == '+') {
                int temp  = (res[resIndex-1] - 48)+(s.charAt(i+1)-48);
                res[resIndex-1] = (char)(temp + 48);
                i++;
            } else {
                res[resIndex] = s.charAt(i);
                resIndex++;
            }
        }
        String temp = "";
        for (int i=0;i<resIndex;i++) {
            temp+=res[i];
        }
        return temp.trim();
    }

    private static String getStringAfterSubtraction(String s) {
        if (!s.contains("-")) {
            return s;
        }
        char res[] = new char[s.length()];
        int resIndex = 0;
        for (int i=0;i<s.length(); i++) {
            if (s.charAt(i) == '-') {
                int temp  = (res[resIndex-1] - 48)-(s.charAt(i+1)-48);
                res[resIndex-1] = (char)(temp + 48);
                i++;
            } else {
                res[resIndex] = s.charAt(i);
                resIndex++;
            }
        }
        String temp = "";
        for (int i=0;i<resIndex;i++) {
            temp+=res[i];
        }
        return temp.trim();
    }
}
