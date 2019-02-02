import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses22 {
    public List<String> generateParenthesis(int n) {
        List<String> res = new LinkedList<>();
        backTrack(n, 0, 0, new StringBuilder(), res);
        return res;
    }
    public void backTrack(int n, int left, int right, StringBuilder sb, List<String> res){
        if(left == right && right ==  n){
            res.add(sb.toString());
            return;
        }
        if(left > n || right > left) return;

        backTrack(n, left + 1, right, sb.append('('), res);
        sb.deleteCharAt(sb.length() - 1);
        backTrack(n, left, right + 1, sb.append(')'), res);
        sb.deleteCharAt(sb.length() - 1);

    }

    @Test
    public void test(){
        System.out.println(generateParenthesis(1));
    }

}

/*
Backtracking的题目
1. Recursive function contains res, path at least
2. For reference, we should recover the path manually.
3. Trick: we can draw the states tree to analysis these kind of problems.
 */
