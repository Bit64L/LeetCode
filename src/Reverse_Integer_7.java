/*
Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output:  321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.


 */


public class Reverse_Integer_7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int x = solution7.reverse(1534236469);
        System.out.println(x);
    }
}

class Solution7 {
    public int reverse(int x) {
        int a,b,mark=0;
        if(x==0) return 0;
        if(x<0){
            x=-x;
            mark=1;
        }
        String ans="";
        while(x>0){
          b=x%10;
          x/=10;
          ans+=b;
        }
        try{
            a = Integer.parseInt(ans);
        }catch (Exception e){
            a=0;
        }
        if(mark==1) a=-a;
        return a;
    }
}
