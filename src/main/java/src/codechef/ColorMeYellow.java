package src.codechef;

import src.fastInputReader.FastReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Map;

public class ColorMeYellow {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        FastReader sc = new FastReader(inputStream);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            int maxColumnColored = maxColumnColored(n ,r ,g ,b);
            out.print(maxColumnColored);
        }
        out.close();
    }

    private static int maxColumnColored(int n, int r, int g, int b) {
        int low = 0;
        int high = Math.min(n, Math.min(r,b));
        int ans = 0;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (good(mid, r, g, b)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return ans;
    }

    private static boolean good(int mid, int r, int g, int b) {
        return r-mid + b-mid + g >= mid;
    }

}
