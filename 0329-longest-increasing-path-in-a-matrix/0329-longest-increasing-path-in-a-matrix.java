class Solution {
    private int[][] memo;
    private int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    public int longestIncreasingPath(int[][] matrix) {
        memo = new int[matrix.length][matrix[0].length];
        int max = 0;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                max = Math.max(max, dfs(i, j, matrix));
            }
        }
        return max;
    }
    
    private int dfs(int i, int j, int[][] matrix){
        if(i < 0 || i >= matrix.length || j < 0 || j >= matrix[0].length) return 0;
        if(memo[i][j] != 0) return memo[i][j];
        int max = 0;
        for(int[] dir : dirs){
            int x = i + dir[0], y = j + dir[1];
            if(x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j])
                max = Math.max(max, dfs(x, y, matrix));
        }
        memo[i][j] = max + 1;
        return memo[i][j];
    }
}