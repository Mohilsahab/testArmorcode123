package src.leetcode;

public class ContainerWithMostRuns {
    public static void main(String[] args) {
        int[] height = {4,3,2,1,4};//16
        System.out.println(new ContainerWithMostRuns().maxArea(height));
    }

    public int maxArea(int[] height) {
        int l=0, r = height.length-1, maxArea = Integer.MIN_VALUE;
        while (l<r) {
            maxArea = Math.max(maxArea, Math.min(height[l],height[r]) * (r-l));
            if (height[l]<height[r]) {
                l++;
            } else {
                r--;
            }
        }
        return maxArea;
    }
}
