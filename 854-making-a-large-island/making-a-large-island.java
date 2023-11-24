class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int largestIsland(int[][] grid) {
        Map<Integer, Integer> islandSizes = new HashMap<>();
        int islandId = 2, maxIslandSize = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int islandSize = getIslandSize(i, j, grid, islandId);
                    islandSizes.put(islandId++, islandSize);
                    maxIslandSize = Math.max(maxIslandSize, islandSize);
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    Set<Integer> seen = new HashSet<>();
                    for(int[] dir : dirs){
                        int row = i + dir[0], col = j + dir[1];
                        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0){
                            seen.add(grid[row][col]);
                        }
                    }
                    int sum = 1;
                    for(int num : seen){
                        sum+= islandSizes.get(num);
                    }
                    maxIslandSize = Math.max(maxIslandSize, sum);
                }
            }
        }
        return maxIslandSize;
    }

    private int getIslandSize(int i, int j, int[][] grid, int islandId){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = islandId;
        return 1 + getIslandSize(i, j-1, grid, islandId) + getIslandSize(i, j + 1, grid, islandId)
            + getIslandSize(i - 1, j, grid, islandId) + getIslandSize(i + 1, j, grid, islandId);
    }
}