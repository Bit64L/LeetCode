import static java.lang.Math.abs;
import static java.lang.Math.min;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * <p>
 * Note: You may not slant the container and n is at least 2.
 */
// 有两个变量，高度和宽度，要求最大面积，将一个变量固定或者递增递减，查看另一个变量


public class Container_With_Most_Water_11 {
    public Solution solution = new Solution();

    class Solution {
        public int maxArea(int[] height) {
            int a = 0, b = height.length - 1;
            int maxArea = 0, tempArea = 0;
            while (a < b) {
                tempArea = abs((b - a) * min(height[a],height[b]));
                if (tempArea > maxArea) {
                    maxArea = tempArea;
                }
                if (height[a] < height[b]) {
                    a++;
                } else {
                    b--;
                }

            }
            return maxArea;
        }
    }


    public static void main(String[] args) {
        Container_With_Most_Water_11 container_with_most_water_11 = new Container_With_Most_Water_11();
        System.out.println(container_with_most_water_11.solution.maxArea(new int[]{1, 1}));
    }
}
