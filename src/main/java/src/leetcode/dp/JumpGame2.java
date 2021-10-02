package src.leetcode.dp;

public class JumpGame2 {
    public static void main(String[] args) {
//        int nums[] = {2,3,1,1,4};
//        int nums[] = {2,3,0,1,4};
        int nums[] = {2,0};
        System.out.println(new JumpGame2().jump(nums));
    }

    public int jump(int[] nums) {
        int ans = 0;
        int maxValue=0;
        int maxJump = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (i + nums[i] > maxJump) {
                maxJump = i + nums[i];
            }
            if (i == maxValue) {
                ans++;
                maxValue = maxJump;
            }
        }
        return ans;
    }

    //DP solution
    public int jumpWithDp(int[] nums) {
        int[] visited = new int[nums.length];
        for (int i=0; i<nums.length; i++) {
            for (int j = i+1; j<= i+nums[i] && j<nums.length; j++) {
                if (visited[j] ==0) {
                    visited[j] = visited[i] + 1;
                }
            }
        }
        return visited[nums.length-1];
    }

}
