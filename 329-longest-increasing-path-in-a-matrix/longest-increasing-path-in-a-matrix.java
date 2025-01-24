class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        int[][] visited = new int[matrix.length][matrix[0].length];
        int result = 0;
        for(int row = 0; row < matrix.length; row++) {
            for(int col = 0; col < matrix[0].length; col++) {
                result = Math.max(result, dfs(row, col, matrix, visited, -1));
            }
        }
        return result;
    }

    private int dfs(int row, int col, int[][] matrix, int[][] visited, int prev) {
        if(row < 0 || row >= matrix.length || col < 0 || col >= matrix[0].length || matrix[row][col] <= prev) return 0;
        //Memoization
        if(visited[row][col] != 0) return visited[row][col];

        int curr = matrix[row][col];
        int left = dfs(row, col - 1, matrix, visited, curr);
        int right = dfs(row, col + 1, matrix, visited, curr);
        int up = dfs(row - 1, col, matrix, visited, curr);
        int down = dfs(row + 1, col, matrix, visited, curr);

        return visited[row][col] = 1 + Math.max(left, Math.max(right, Math.max(up, down)));
    }
}