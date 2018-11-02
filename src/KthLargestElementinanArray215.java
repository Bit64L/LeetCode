import org.junit.Test;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Random;

public class KthLargestElementinanArray215 {

    public int findKthLargest(int[] nums, int k) {
        shuffle(nums);
        int lo=0,hi = nums.length-1;
        while (true) {
            int p = partition(nums, lo, hi);
            if (p == nums.length - k) {
                break;
            } else if (p > nums.length - k) {
                hi = p - 1;
            } else {
                lo = p + 1;
            }
        }
        return nums[nums.length-k];
    }

    public int partition(int[] nums, int lo, int hi) {
        int i = lo + 1, j = hi;
        while (true) {
            while (i <= j && nums[i] <= nums[lo]) i++;
            while (nums[j] > nums[lo]) j--;
            if (i > j)
                break;
            swap(nums, i, j);
        }
        swap(nums, lo, j);
        return j;
    }
    private void shuffle(int a[]) {
        final Random random = new Random();
        for(int ind = 1; ind < a.length; ind++) {
            final int r = random.nextInt(ind + 1);
            swap(a, ind, r);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public int findKthLargest2(int[] nums, int k) { // 排序
        if (nums == null || nums.length == 0) {
            return 0;
        }
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    public int findKthLargest1(int[] nums, int k) {// 优先级队列

        final PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
    }

    @Test
    public void test() {
        int[] nums = {1, 5, 6, 7, 2, 3};
        System.out.println(findKthLargest(nums, 1));
    }
}
