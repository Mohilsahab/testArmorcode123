package src.test;

import java.util.Arrays;
import java.lang.*;

class Test
{
    static int oddHop[];
    static int evenHop[];
    static int ODD = 0;
    static int EVEN =1;

    public static void main(String[] args) {

        int[] a= new int[]{ 2,3,1,1,4};
        oddHop = new int[a.length];
        evenHop = new int[a.length];
        Arrays.fill(oddHop, -1);
        Arrays.fill(evenHop, -1);
        int count =0;
        for (int i=0;i<a.length;i++) {
            if (countPossibleHops(a, i, ODD) ==1)
                count++;
        }
        System.out.println(count);
    }

    static int countPossibleHops (int a[], int i, int hopTurn) {//2,3,1,1,4
        if (i==a.length-1) {
            oddHop[a.length-1] = 1;
            return 1;
        }

        if (hopTurn==ODD) {//2,3,1,1,4
            if (oddHop[i]!=-1) {
                if (evenHop[i]==1) {
                    return 1;
                }
                return oddHop[i];
            }
            int index = getNextJustLargerIndex(a, i);
            if (index == a.length) {
                oddHop[i] = 0;
                return 0;
            } else if (index == a.length-1) {
                oddHop[i] = 1;
                return 1;
            }

            if (oddHop[index]!=-1) {
                oddHop[i] = oddHop[index];
                return oddHop[index];
            }
            return countPossibleHops (a, index, EVEN);
        } else {
            if (evenHop[i]!=-1) {
                if (oddHop[i]==1) {
                    return 1;
                }
                return evenHop[i];
            }
            int index = getNextJustSmallerIndex(a, i);
            if (index ==a.length) {
                evenHop[i] = 0;
                return 0;
            } else if (index == a.length-1) {
                evenHop[i] = 1;
                return 1;
            }

            if (evenHop[index]!=-1) {
                evenHop[i] = evenHop[index];
                return evenHop[index];
            }
            return countPossibleHops (a, index, ODD);

        }

    }
    //2,3,1,1,4
    private static int getNextJustLargerIndex(int[] a, int index) {
        int nextIndex = a.length;
        int temp = a[index];
        for (int  i = index + 1; i<a.length; i++) {
            if (a[i] > temp) {
                temp = a[i];
                nextIndex = i;
                break;
            }
        }
        for (int i = nextIndex + 1; i<a.length; i++) {
            if (temp > a[i] && a[i] > a[index]) {
                temp = a[i];
                nextIndex = i;
            }
        }
        return nextIndex;
    }

    private static int getNextJustSmallerIndex(int[] a, int index) {
        int nextIndex = a.length;
        int temp = a[index];
        for (int  i = index + 1; i<a.length; i++) {
            if (a[i] < temp) {
                temp = a[i];
                nextIndex = i;
                break;
            }
        }
        for (int i = nextIndex + 1; i<a.length; i++) {
            if (temp < a[i] && a[i] < a[index]) {
                temp = a[i];
                nextIndex = i;
            }
        }
        return nextIndex;
    }
}
