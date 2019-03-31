import java.util.ArrayList;
import java.util.List;

public class Permutations46 {
    public List<List<Integer>> permute(int[] nums) {
        if(nums == null || nums.length == 0) return new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        backTrack(res, new ArrayList<>(), nums);
        return res;
    }

    public void backTrack(List<List<Integer>> res, List<Integer> path, int[] nums){
        if(path.size() == nums.length){
            res.add(new ArrayList<>(path));
            return;
        }

        for(int i = 0; i < nums.length; i++){
            if(path.contains(nums[i])) continue;
            path.add(nums[i]);
            backTrack(res, path, nums);
            path.remove(path.size() - 1);
        }

    }
}
