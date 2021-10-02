package src.codechef;

import src.fastInputReader.FastReader;

import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        FastReader sc = new FastReader(inputStream);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);

        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            countSort(arr, n);
            for (int i=0; i<n; i++) {
                out.print(arr[i] + " ");
            }
        }
        out.close();
    }

    private static void countSort(int[] arr, int n) {
        int res[] = new int[n];
        int temp[] = getTempArray(arr, n);

        for (int i=0; i<n; i++) {
            res[temp[arr[i]]-1] = arr[i];
            temp[arr[i]]--;
        }


        for (int i=0;i<n;i++) {
            arr[i] = res[i];
        }
    }

    private static int[] getTempArray(int[] arr, int n) {
        int max = Arrays.stream(arr).max().getAsInt();

        int temp[] = new int[max+1];
        Arrays.fill(temp, 0);
        for (int i = 0; i<n; i++) {
            temp[arr[i]]++;
        }
        for (int i = 1; i<=max; i++) {
            temp[i]=temp[i]+temp[i-1];
        }
        return temp;
    }
}
