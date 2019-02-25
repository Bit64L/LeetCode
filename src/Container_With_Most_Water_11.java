/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
// 有两个变量，高度和宽度，要求最大面积，将一个变量固定或者递增递减，查看另一个变量


public class Container_With_Most_Water_11 {
    public int maxArea(int[] height) {
        if(height == null || height.length == 0) return 0;
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while(left < right){
            int tmpArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, tmpArea);
            if(height[left] < height[right])
                left++;
            else
                right--;
        }
        return maxArea;

    }
}

/*
Two Pointers
height[left] < height[right]时 left右移
因为如果right左移的话，面积一定不会增大。
 */