class Solution {
    public int minFallingPathSum(int[][] matrix) {
        if(matrix.length == 1) return matrix[0][0];
        int rowLength = matrix.length, colLength = matrix[0].length;
        int[][] dp = new int[rowLength][colLength];
        dp[0][0] = matrix[0][0];
        for(int i = 1; i < dp.length; i++)
            dp[0][i] = matrix[0][i];
        for(int i = 1; i < rowLength; i++){
            for(int j = 0; j < colLength; j++){
                if(j == 0){
                    dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j+1]) + matrix[i][j];
                }else if(j == colLength - 1){
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j]) + matrix[i][j];
                }else {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i-1][j+1])) + matrix[i][j];
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < colLength; i++)
            min = Math.min(min, dp[rowLength - 1][i]);
        return min;
    }
}