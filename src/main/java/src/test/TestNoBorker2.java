package src.test;

public class TestNoBorker2 {

    //{1,0,1}
    //sum of subarray = length of subarray
    //ans =3

    public static void main(String[] args) {
        int []arr = {1,0,1};
        System.out.println(sameSubArrayLengthAndSum(arr));
    }

    private static int sameSubArrayLengthAndSum(int[] arr) {
        int count = 0;
        int sum[] = arr;
        for (int i=1; i<arr.length; i++) {
            sum[i]+=sum[i-1];
        }
        for (int i=0;i<arr.length; i++) {
            if (arr[i]==1) {
                count++;
            }
        }
        for (int i=1; i<arr.length; i++) {
            for (int j=0;j<i; j++) {
                int x= sum[i] - sum[j] ;
                int y = i-j;
                if (x==y || (x!=y && sum[i]==sum[j])) {
                    count++;
                }
            }
        }
        return count;
    }
}
