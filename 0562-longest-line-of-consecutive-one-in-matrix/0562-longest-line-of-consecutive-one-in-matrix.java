class Solution {
    //3D DP: O(n^2)
    public int longestLine(int[][] mat) {
        //base case: index 0, length = mat[0][0] == 1 ? 1 : 0
        int longestLine = 0;
        int[][][] dp = new int[mat.length][mat[0].length][4];
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 0){
                    dp[i][j][1] = i > 0 ? dp[i - 1][j][1] + 1 : 1; //horizontal
                    dp[i][j][0] = j > 0 ? dp[i][j - 1][0] + 1 : 1; //vertical
                    dp[i][j][2] = (i > 0 && j > 0) ? dp[i - 1][j - 1][2] + 1 : 1; //diag                 
                    dp[i][j][3] = (i > 0 && j < mat[0].length - 1) ? dp[i - 1][j + 1][3] + 1 : 1; //anti diag
                    longestLine = Math.max(longestLine, Math.max(Math.max(dp[i][j][0], dp[i][j][1]), Math.max(dp[i][j][2], dp[i][j][3])));
                }
            }
        }
        return longestLine;
    }
}