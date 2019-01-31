/**
 * Implement strStr().

 Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 Example 1:

 Input: haystack = "hello", needle = "ll"
 Output: 2
 Example 2:

 Input: haystack = "aaaaa", needle = "bba"
 Output: -1
 */

public class Implement_strStr_28 {
    public int strStr(String haystack, String needle) {
        int N = haystack.length();
        int M = needle.length();
        int[] jump = new int[256];
        for(int i=0;i<255;i++) jump[i] = -1;
        for(int i=0;i<M;i++){
            jump[needle.charAt(i)]=i;
        }
        int skip = 0;
        for(int i=0;i<= N-M; i+=skip){
            int j;
            for(j=M-1;j>=0;j--){// 从尾部开始匹配
                if(needle.charAt(j) != haystack.charAt(i+j)){
                    skip = j - jump[haystack.charAt(i+j)];
                    if(skip < 0) skip = 1;
                    break;
                }
            }
            if(j == -1) return i;
        }
        return -1;
    }
}
