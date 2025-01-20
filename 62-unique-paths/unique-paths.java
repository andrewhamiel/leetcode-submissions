class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        //First row
        for(int col = 0; col  < dp[0].length; col++) dp[0][col] = 1;
        //First col
        for(int[] row : dp) row[0] = 1;

        for(int row = 1; row < dp.length; row++) {
            for(int col = 1; col < dp[0].length; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}