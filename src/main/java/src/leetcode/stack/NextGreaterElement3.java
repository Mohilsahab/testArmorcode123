package src.leetcode.stack;

import java.util.ArrayList;
import java.util.List;

public class NextGreaterElement3 {
    public static void main(String[] args) {
        System.out.println(new NextGreaterElement3().nextGreaterElement(2147483476));
        System.out.println(new NextGreaterElement3().nextGreaterElement(12));
        System.out.println(new NextGreaterElement3().nextGreaterElement(21));
        System.out.println(new NextGreaterElement3().nextGreaterElement(5));
    }

    public int nextGreaterElement(int n) {
        List<Integer> list=new ArrayList<>();
        while(n!=0){
            list.add(0,n%10);
            n=n/10;
        }
        //list now becomes [3,2,4,7,6,5]

        // finding first descending digit from right side..i.e. 4, store its index in left...left= 2
        int left =-1;
        for(int i=list.size()-1;i>=1;i--){
            if(list.get(i)>list.get(i-1)){
                left=(i-1);
                break;
            }
        }
        // if there is no descending digit there is no greater element available so return -1..for ex. 11111
        if(left==-1){
            return -1;
        }

        // finding next larger digit.. keep in mind start from the right side and first larger element that we encounter is the next larger (difference is minimum). i.e. 5, store its index in right...right=5

        int right=list.size()-1;
        while (list.get(right) <= list.get(left)) {
            right--;
        }

        // swap
        swap(list, left, right);
        //now list becomes [3,2,5,7,6,4]

        // reverse elements after left
        left=left+1;
        right=list.size()-1;
        while(left<right){
            swap(list,left,right);
            left++;
            right--;
        }
        //now list becomes [3,2,5,4,6,7]


        // store in form of a number to return
        long ans=0;
        for(int i=0;i<list.size();i++){
            ans=ans*10+list.get(i);
        }
        if(ans>Integer.MAX_VALUE){
            return -1;
        }
        return (int)ans;

    }

    public void swap(List<Integer> list, int left, int right){
        int temp=list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }

}
