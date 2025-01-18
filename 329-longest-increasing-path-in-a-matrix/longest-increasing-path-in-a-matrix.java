class Solution {
    private int[][] memo;

    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];

        int longest = 0;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                longest = Math.max(longest, dfs(row, col, matrix, -1));
            }
        }
        return longest;
    }

    private int dfs(int i, int j, int[][] matrix, int prevVal) {
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length || matrix[i][j] <= prevVal) return 0;

        if(memo[i][j] != 0) return memo[i][j];

        int currVal = matrix[i][j];
        int left = dfs(i, j - 1, matrix, currVal);
        int right = dfs(i, j + 1, matrix, currVal);
        int up = dfs(i - 1, j, matrix, currVal);
        int down = dfs(i + 1, j, matrix, currVal);

        return memo[i][j] = 1 + Math.max(left, Math.max(right, Math.max(up, down)));
    }
}