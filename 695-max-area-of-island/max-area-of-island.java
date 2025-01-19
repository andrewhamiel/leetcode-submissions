class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) maxArea = Math.max(maxArea, dfs(row, col, grid));
            }
        }
        return maxArea;
    }

    private int dfs(int row, int col, int[][] grid) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) return 0;
        grid[row][col] = 0;
        int left = dfs(row, col - 1, grid);
        int right = dfs(row, col + 1, grid);
        int up = dfs(row - 1, col, grid);
        int down = dfs(row + 1, col, grid);

        return 1 + left + right + up + down;
    }
}