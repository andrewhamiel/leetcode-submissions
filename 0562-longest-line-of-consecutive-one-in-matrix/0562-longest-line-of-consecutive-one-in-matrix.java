class Solution {
    //3D Dynamic Programming problem
    public int longestLine(int[][] mat) {
        int[][][] dp = new int[mat.length][mat[0].length][4];
        int longestLine = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 0){
                    dp[i][j][0] = (i > 0) && dp[i-1][j][0] != 0 ? dp[i-1][j][0] + 1 : 1;
                    dp[i][j][1] = (j > 0) && dp[i][j-1][1] != 0 ? dp[i][j-1][1] + 1 : 1;
                    dp[i][j][2] = (i > 0) && (j > 0) && dp[i-1][j-1][2] != 0 ? dp[i-1][j-1][2] + 1 : 1;
                    dp[i][j][3] = (i > 0) && (j+1) < mat[0].length && dp[i-1][j+1][3] != 0 ? dp[i-1][j+1][3] + 1 : 1;
                    longestLine = Math.max(longestLine, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return longestLine;
    }
}