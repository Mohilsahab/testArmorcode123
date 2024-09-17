package src.spoj;

import src.fastInputReader.FastReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        FastReader sc = new FastReader(inputStream);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int c = sc.nextInt();
            int arr[] = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            Arrays.sort(arr);
            int minDistance = minDistance(arr, n, c);
            out.print(minDistance);
        }
        out.close();
    }

    private static int minDistance(int[] arr, int n, int c) {
        int low = 0;
        int high = n-1;
        int ans = 0;
        while (low<=high) {
            int mid = low + (high-low)/2;
            if (good(mid, arr, c)) {

            } else {

            }
        }
        return ans;
    }

    private static boolean good(int mid, int[] arr, int c) {
        int temp = 1;
        for (int i=mid; i<arr.length - 1; i+=mid) {

        }
        return false;
    }
}
