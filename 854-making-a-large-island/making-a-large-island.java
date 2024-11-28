class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int maxArea = 0, islandId = 2;
        Queue<int[]> q = new LinkedList<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    int area = dfs(row, col, grid, islandId);
                    islandSizes.put(islandId++, area);
                    maxArea = Math.max(maxArea, area);
                }else if(grid[row][col] == 0) q.add(new int[]{row, col});
            }
        }

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            Set<Integer> visitedIslands = new HashSet<>();
            int area = 1;
            for(int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] != 0 && !visitedIslands.contains(grid[newRow][newCol])){
                        visitedIslands.add(grid[newRow][newCol]);
                        area+= islandSizes.getOrDefault(grid[newRow][newCol], 0);
                    }
            }
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private int dfs(int i, int j, int[][] grid, int islandId) {
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;

        grid[i][j] = islandId;
        int left = dfs(i, j - 1, grid, islandId);
        int right = dfs(i, j + 1, grid, islandId);
        int up = dfs(i - 1, j, grid, islandId);
        int down = dfs(i + 1, j, grid, islandId);
        return 1 + left + right + up + down; 
    }
}