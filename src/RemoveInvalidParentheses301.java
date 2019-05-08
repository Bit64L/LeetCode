import java.util.LinkedList;
import java.util.List;

public class RemoveInvalidParentheses301 {
    public List<String> removeInvalidParentheses(String s) {
        int l = 0, r = 0;
        for(Character c : s.toCharArray()){
            if(c == '(') l++;
            else if(c == ')'){
                if(l == 0) r++;
                else l--;
            }
        }

        List<String> res = new LinkedList<>();
        dfs(s, 0, l, r, res);
        return res;
    }

    public boolean valid(String s){
        int count = 0;
        for(Character c : s.toCharArray()){
            if(c == '(') count++;
            else if(c == ')') count--;
            if(count < 0) return false;
        }
        return count == 0;
    }


    public void dfs(String s, int start, int l, int r, List<String> res){
        if(l == 0 && r == 0 && valid(s)){
            res.add(s);
            return;
        }

        for(int i = start; i < s.length(); i++){

            if(i > 0 && s.charAt(i) == s.charAt(i-1)) continue;

            StringBuilder sb = new StringBuilder(s);
            sb.deleteCharAt(i);
            if(s.charAt(i) == '(' && l > 0){
                dfs(sb.toString(), i, l - 1, r, res);
            }else if(s.charAt(i) == ')' && r > 0){
                dfs(sb.toString(), i, l, r - 1, res);
            }
        }
    }
}
/*
1. 先计数要删除左括号和右括号的数量
2. dfs枚举删除
 */