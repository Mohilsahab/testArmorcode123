package src.leetcode.dp;

public class JumpGame {
    public static void main(String[] args) {
//        int nums[] = {2,3,1,1,4};
        int nums[] = {3,2,1,0,4};
//        int nums[] = {2,0};
        System.out.println(new JumpGame().canJump(nums));
    }

    public boolean canJump(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        canJump(nums, visited, 0);
        return visited[nums.length-1];
    }

    private void canJump(int[] nums, boolean[] visited, int index) {
        if (index >= nums.length) {
            return;
        }
        visited[index] = true;
        if (index + nums[index] >= nums.length - 1) {
            visited[nums.length-1] = true;
            return;
        }
        for (int i = index+1; i <= index + nums[index] && i < nums.length; i++) {
            if (!visited[i] && nums[i]>0) {
                visited[i] = true;
                canJump(nums, visited, i);
            }
        }
    }
}
