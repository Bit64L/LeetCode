import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0 ) return new ArrayList<>();
        Map<Character, String> map = new HashMap<Character, String>(){
            {
                put('2', "abc");
                put('3', "def");
                put('4', "ghi");
                put('5', "jkl");
                put('6', "mno");
                put('7', "pqrs");
                put('8', "tuv");
                put('9', "wxyz");
            }
        };
        List<String> res = new ArrayList<>();
        backTracking(map, 0, digits, new StringBuilder(), res);
        return res;
    }
    public void backTracking(Map<Character, String> map, int i, String digits, StringBuilder path, List<String> res){
        if(i >= digits.length()){
            res.add(path.toString());
            return;
        }

        String str = map.get(digits.charAt(i));
        for(Character c : str.toCharArray()){
            path.append(c);
            backTracking(map, i+1, digits, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }

    public List<String> letterCombinations1(String digits) {
        if(digits == null || digits.length() == 0 ) return new ArrayList<>();
        String[] strs = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> res = new ArrayList<>();
        backTracking(strs, 0, digits, new StringBuilder(), res);
        return res;
    }
    public void backTracking(String[] strs, int i, String digits, StringBuilder path, List<String> res){
        if(i >= digits.length()){
            res.add(path.toString());
            return;
        }

        for(Character c : strs[digits.charAt(i) - '0'].toCharArray()){
            path.append(c);
            backTracking(strs, i+1, digits, path, res);
            path.deleteCharAt(path.length() - 1);
        }
    }
}

/*
1. 用Backtracking解决无法动态创建for循环的问题
2. 熟练Map的初始化方式
3. 其余基本为经典的Backtracking模板

优化
1. 用String数组代替Map
 */