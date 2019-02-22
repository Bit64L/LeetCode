public class MultiplyStrings43 {
    public String multiply(String num1, String num2) {
        int m = num1.length(), n = num2.length();
        int[] pos = new int[m + n];
        for(int j = n - 1; j >= 0; j--){
            for(int i = m - 1; i >= 0; i--){
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j, p2 = i + j + 1;
                int sum = mul + pos[p2];
                pos[p1] += sum / 10;
                pos[p2] = sum % 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        int i;
        for(i = 0; i < (m + n - 1) && pos[i] == 0; i++);
        for(; i < m + n; i++) sb.append(pos[i]);
        return sb.toString();
    }
}

/*
大数乘法，模拟
https://leetcode.com/problems/multiply-strings/discuss/17605/Easiest-JAVA-Solution-with-Graph-Explanation
 */