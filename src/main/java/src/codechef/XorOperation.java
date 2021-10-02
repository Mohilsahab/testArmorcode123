package src.codechef;

import java.util.Scanner;

public class XorOperation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i=0; i<n; i++) {
                arr[i] = sc.nextInt();
            }
            System.out.println(getXOR(arr, n));
        }
    }

    private static int getXOR(int[] arr, int n) {
        int xor = arr[0];
        for (int i=1; i<n;i++) {
            xor = xor^arr[i];
        }
        return xor;
    }
}
