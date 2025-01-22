class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int largestIsland(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2, maxIslandSize = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) {
                    int area = dfs(row, col, grid, islandId);
                    islandSizes.put(islandId++, area);
                    maxIslandSize = Math.max(maxIslandSize, area);
                }else if(grid[row][col] == 0) q.add(new int[]{row, col});
            }
        }

        while(!q.isEmpty()) {
            int[] vertex = q.poll();
            int row = vertex[0], col = vertex[1];

            Set<Integer> visited = new HashSet<>();
            int area = 1;
            for(int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && grid[newRow][newCol] != 0 && !visited.contains(grid[newRow][newCol])) {
                        visited.add(grid[newRow][newCol]);
                        area+= islandSizes.get(grid[newRow][newCol]);
                    }
            }
            maxIslandSize = Math.max(maxIslandSize, area);
        }
        return maxIslandSize;
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