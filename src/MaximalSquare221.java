import org.junit.Test;

public class MaximalSquare221 {
    public int maximalSquare(char[][] matrix) {
        if(matrix == null || matrix.length == 0)
            return 0;
        char[][] dp = new char[matrix.length][matrix[0].length];
        char ans = 0;
        for(int i=0;i<matrix.length;i++){
            dp[i][0] = matrix[i][0];
            ans = (char)Math.max(ans,dp[i][0]);
        }
        if(matrix.length == 1)
            return (ans-48)*(ans-48);
        for(int i=0;i<matrix[0].length;i++){
            dp[0][i] = matrix[0][i];
            ans = (char)Math.max(ans,dp[0][i]);
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j] == 0)
                    dp[i][j] = 0;
                else{
                    dp[i][j] = (char)(Math.min(Math.min(dp[i-1][j],dp[i-1][j-1]),dp[i][j-1]) + 1);
                    ans = (char)Math.max(ans,dp[i][j]);
                }
            }
        }
        return (ans-48)*(ans-48);
    }

    @Test
    public void test(){
        char[][] arr = {{'1','0','1','0','0'},{}};
        System.out.println(maximalSquare(arr));
    }
}
