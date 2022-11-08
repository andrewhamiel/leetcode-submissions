class Solution {
    int mod = 1000000007, m = 0, n = 0;
    int[][][] memo;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        this.m = m;
        this.n = n;
        memo = new int[m][n][maxMove + 1];
        for(int[][] mat : memo)
            for(int[] row : mat) Arrays.fill(row, -1);
        return dp(startRow, startColumn, maxMove);
    }
    
    private int dp(int i, int j, int moves){
        if(i < 0 || i >= m || j < 0 || j >= n) return 1;
        if(moves == 0) return 0;
        if(memo[i][j][moves] != -1) return memo[i][j][moves];
        memo[i][j][moves] = (
        (dp(i-1, j, moves-1) + dp(i+1, j, moves - 1)) % mod
            + (dp(i, j-1, moves-1) + dp(i, j+1, moves-1)) % mod
        ) % mod;
        return memo[i][j][moves];
    }
}