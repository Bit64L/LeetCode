/**
 * Given a sorted array, remove the duplicates in-place such that each element appear only once and return the new length.

 Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

 Example:

 Given nums = [1,1,2],

 Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 It doesn't matter what you leave beyond the new length.
 */


public class Remove_Duplicates_from_Sorted_Array_26 {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length==0) return 0;
        int i=0,j=1;
        while(j<nums.length){
            if(nums[i] == nums[j]) j++;
            else{
                i++;
                nums[i] = nums[j];
                j++;
            }
        }
        return i+1;
    }

    public static void main(String[] args) {
        Remove_Duplicates_from_Sorted_Array_26 remove_duplicates_from_sorted_array_26 = new Remove_Duplicates_from_Sorted_Array_26();
        System.out.println(remove_duplicates_from_sorted_array_26.removeDuplicates(new int[]{1, 1, 1, 2, 3, 4, 5}));
    }
}
