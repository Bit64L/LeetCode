/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 *
 *
 *
 *
 Some hints:
 Could negative integers be palindromes? (ie, -1)

 If you are thinking of converting the integer to string, note the restriction of using extra space.

 You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

 There is a more generic way of solving this problem.

 三种思路：
 1. int to string
 2. reverse original number
 3. reverse half of the original
 */



public class Palindrome_Number_9 {
    class Solution9{
        public boolean isPalindrome(int x) {
            if(x<0 || (x!=0 && x%10 == 0)) return false;
            int lasthalf = 0;
            while(x > lasthalf){
                lasthalf = lasthalf * 10 + x % 10;
                x /= 10;
            }
            if(x == lasthalf || x == lasthalf/10)
                return true;
            return false;
        }
    }
    public Solution9 solution9 = new Solution9();

    public static void main(String[] args) {
        Palindrome_Number_9 test = new Palindrome_Number_9();
        for(int i=100;i<1000;i++){
            boolean ans = test.solution9.isPalindrome(i);
            System.out.println(i+"  "+ans);
        }

    }

}
