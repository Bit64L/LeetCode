import java.util.LinkedList;
import java.util.List;

public class CombinationSum39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> path = new LinkedList<>();
        List<List<Integer>>ans = new LinkedList<>();
        helper(0, path, ans, candidates,target);
        return ans;
    }
    public void helper(int startIndex, List<Integer> path, List<List<Integer>> ans, int[] candidates, int target){
        if(target < 0) return;
        if(target == 0){
            ans.add(new LinkedList<>(path));
            return;
        }
        for(int i=startIndex;i<candidates.length;i++){
            path.add(candidates[i]);
            helper(i, path, ans, candidates, target-candidates[i]);
            ((LinkedList)path).removeLast();
        }
    }
}
