class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2, maxSize = 0;
        Queue<int[]> q = new LinkedList<>();

        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    int size = dfs(row, col, grid, islandId);
                    islandSizes.put(islandId++, size);
                    maxSize = Math.max(maxSize, size);
                }else if(grid[row][col] == 0) q.add(new int[]{row, col});
            }
        }

        while(!q.isEmpty()) {
            int[] cell = q.poll();
            int row = cell[0], col = cell[1];
            int area = 1;
            Set<Integer> visited = new HashSet<>();
            for(int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length && !visited.contains(grid[newRow][newCol])){
                    visited.add(grid[newRow][newCol]);
                    area+= islandSizes.getOrDefault(grid[newRow][newCol], 0);
                }
            }
            maxSize = Math.max(maxSize, area);
        }
        return maxSize;
    }

    private int dfs(int row, int col, int[][] grid, int islandId) {
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) return 0;
        grid[row][col] = islandId;

        int left = dfs(row, col - 1, grid, islandId);
        int right = dfs(row, col + 1, grid, islandId);
        int up = dfs(row - 1, col, grid, islandId);
        int down = dfs(row + 1, col, grid, islandId);
        return 1 + left + right + up + down;
    }
}