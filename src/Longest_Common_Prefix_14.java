/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 */


public class Longest_Common_Prefix_14 {
    private Solution solution = new Solution();
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            if(strs == null || strs.length == 0) return "";
            if(strs.length == 1) return strs[0];
            String ans="";
            char character;
            boolean mark = true;
            for(int i=0;i<strs[0].length();i++){
                character = strs[0].charAt(i);
                for(int j=1;j<strs.length;j++){
                    if(strs[j].length() - 1 < i || strs[j].charAt(i)!=character) {
                        mark =false;
                        break;
                    }

                }
                if(!mark) break;
                ans+=character;
            }
            return ans;
        }
    }

    public static void main(String[] args) {
        Longest_Common_Prefix_14 longest_common_prefix_14 = new Longest_Common_Prefix_14();
        System.out.println(longest_common_prefix_14.solution.longestCommonPrefix(new String[]{"babb", "caa"}));
    }

}
