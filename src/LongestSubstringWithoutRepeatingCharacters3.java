import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() ==0) return 0;
        int res = 0, n = s.length();
        int start = 0, end = 0;
        HashSet<Character> set = new HashSet<>();
        while(start < n && end < n){
            if(!set.contains(s.charAt(end))){
                set.add(s.charAt(end));
                res = Math.max(res, end - start + 1);
                end++;
            }else{
                set.remove(s.charAt(start++));
            }
        }
        return res;
    }
}
