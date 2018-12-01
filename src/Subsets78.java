import java.util.ArrayList;
import java.util.List;

public class Subsets78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> path = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(0, path, res, nums);
        return res;
    }
    public void helper(int start, List<Integer>path, List<List<Integer>>res, int[] nums){
        res.add(new ArrayList<>(path));
        if(start >= nums.length)
            return;
        for(int i=start;i<nums.length;i++){
            path.add(nums[i]);
            helper(i+1, path, res, nums);
            path.remove(path.size()-1);
        }
    }
}
