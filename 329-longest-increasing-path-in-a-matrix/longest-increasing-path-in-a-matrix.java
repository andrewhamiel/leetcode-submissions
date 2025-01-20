class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] memo = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                result = Math.max(result, dfs(row, col, matrix, memo, -1));
            }
        }
        return result;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] memo, int prevVal) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prevVal) return 0;

        if(memo[row][col] != 0) return memo[row][col];
        memo[row][col] = 1;

        int currVal = matrix[row][col];

        int left = dfs(row, col - 1, matrix, memo, currVal);
        int right = dfs(row, col + 1, matrix, memo, currVal);
        int up = dfs(row -1, col, matrix, memo, currVal);
        int down = dfs(row + 1, col, matrix, memo, currVal);

        return memo[row][col] = memo[row][col] + Math.max(left, Math.max(right, Math.max(up, down)));
    }
}