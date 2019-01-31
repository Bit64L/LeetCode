import java.util.ArrayList;
import java.util.List;

public class MajorityElementII229 {
    public List<Integer> majorityElement(int[] nums) {
        if (nums == null) return new ArrayList<>();
        int a = 0, b = 0, ca = 0, cb = 0;
        List<Integer> res = new ArrayList<>();
        for (Integer num : nums) {
            if (a == num) {
                ca++;
            } else if (b == num) {
                cb++;
            } else if (ca == 0) {
                a = num;
                ca = 1;
            } else if (cb == 0) {
                b = num;
                cb = 1;
            } else {
                cb--;
                ca--;
            }
        }
        ca = 0;
        cb = 0;
        for (Integer num : nums) {
            if (a == num) ca++;
            if (b == num) cb++;
        }
        if (ca > nums.length / 3) res.add(a);
        if (a != b && cb > nums.length / 3) res.add(b);
        return res;
    }
}
/*
摩尔投票法：
首先最多有两个数出现次数超过1/3
第一步 先选出两个待选众数
第二步 验证待选众数是否正确
 */