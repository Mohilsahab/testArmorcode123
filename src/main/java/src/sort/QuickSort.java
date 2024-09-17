package src.sort;

public class QuickSort {
    public static void main(String[] args) {
        int arr[] = {3,4,2,5,1,6};
        sort(arr, 0, arr.length-1);
        for (int i: arr) {
            System.out.print(i + " ");
        }
    }

    private static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);

            sort(arr, low, pivot - 1);
            sort(arr, pivot+1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j= low; j<high; j++) {
            if (arr[j] < pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }


}