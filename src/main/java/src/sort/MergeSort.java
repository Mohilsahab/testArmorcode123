package src.sort;

public class MergeSort {
    public static void main(String[] args) {
        int arr[] = {3,4,2,5,1,6};
        sort(arr, 0, arr.length-1);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int mid = low + (high-low)/2;
            sort(arr, low, mid);
            sort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int l1 = mid-low+1;
        int l2 = high - mid;

        int left[] = new int[l1];
        int right[] = new int[l2];
        for (int i=0; i<l1; i++) {
            left[i] = arr[low+i];
        }
        for (int i=0; i<l2; i++) {
            right[i] = arr[mid+1+i];
        }

        int i = 0, j = 0;
        int k = low;
        while (i < l1 && j < l2) {
            if (left[i] <= right[j]) {
                arr[k] = left[i];
                i++;
            }
            else {
                arr[k] = right[j];
                j++;
            }
            k++;
        }

        while (i < l1) {
            arr[k] = left[i];
            i++;
            k++;
        }

        while (j < l2) {
            arr[k] = right[j];
            j++;
            k++;
        }
    }
}
