class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int largestIsland(int[][] grid) {
        int maxSize = 0, islandId = 2;
        Map<Integer, Integer> islandSizes = new HashMap<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int size = getIslandSize(i, j, grid, islandId);
                    islandSizes.put(islandId++, size);
                    maxSize = Math.max(maxSize, size);
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    Set<Integer> nums = new HashSet<>();
                    for(int[] dir : dirs){
                        int newRow = i + dir[0], newCol = j + dir[1];
                        if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                            && grid[newRow][newCol] != 0) nums.add(grid[newRow][newCol]);
                    }
                    int sum = 1;
                    for(int num : nums) sum+= islandSizes.get(num);
                    maxSize = Math.max(maxSize, sum);
                }
            }
        }
        return maxSize;
    }

    private int getIslandSize(int i, int j, int[][] grid, int islandId){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = islandId;
        int left = getIslandSize(i, j-1, grid, islandId);
        int right = getIslandSize(i, j+1, grid, islandId);
        int up = getIslandSize(i-1, j, grid, islandId);
        int down = getIslandSize(i+1, j, grid, islandId);
        return 1 + left + right + up + down;
    }
}