/**
 * Given an array and a value, remove all instances of that value in-place and return the new length.
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * <p>
 * Example:
 * <p>
 * Given nums = [3,2,2,3], val = 3,
 * <p>
 * Your function should return length = 2, with the first two elements of nums being 2.
 */

public class Remove_Element_27 {
    public int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) return 0;
        int i = -1, j = 0;
        while (j < nums.length) {
            if(nums[j] == val) j++;
            else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        Remove_Element_27 remove_element_27 = new Remove_Element_27();
        System.out.println(remove_element_27.removeElement(new int[]{3, 2, 2, 3}, 3));
    }
}
