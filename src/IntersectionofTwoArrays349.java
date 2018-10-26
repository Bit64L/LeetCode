import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

public class IntersectionofTwoArrays349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0;
        HashSet<Integer> set = new HashSet<>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        int[] ans = new int[set.size()];
        int k =0;
        for(Integer val : set){
            ans[k++] = val;
        }
        return ans;
    }

    @Test
    public void test(){
        int[] nums1={1,2,2,4,0};
        int[] nums2={4};
        System.out.println(intersection(nums1, nums2));
    }
}
