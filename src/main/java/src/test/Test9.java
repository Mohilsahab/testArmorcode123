package src.test;

public class Test9 {
    public static void main(String[] args) {
        int a[] = {1, 3, 3, 5, 7};
        int res = firstOccurance(a,3);
        System.out.println(res);
    }

    private static int firstOccurance(int a[], int x) {
        int low = 0;
        int high  = a.length-1;
        int mid;
        int res = -1;
        while (low <= high) {
            mid = (low + high)/2;
            if (a[mid] == x) {
                res = mid;
                high = mid - 1;
            } else if (a[mid] < x) {
                low = mid+1;
            } else {
                high = mid-1;
            }
        }
        return res;
    }
}