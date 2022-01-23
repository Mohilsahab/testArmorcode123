package src.leetcode;

public class MajorityElement {
    public static void main(String[] args) {
        int nums[] = {2,2,2,1,1,2}; //2
//        int nums[] = {1,3,1,1,4,1,1,5,1,1,6,2,2}; //1
        System.out.println(new MajorityElement().majorityElement(nums));
    }

    public int majorityElement(int[] nums) {
        int count = 1;
        int majorityElement = nums[0];
        for (int i=1;i<nums.length; i++) {
            if (majorityElement == nums[i]) {
                count++;
            } else {
                count--;
                if (count<=0) {
                    count=1;
                    majorityElement = nums[i];
                }
            }
        }
        return majorityElement;
    }
}
