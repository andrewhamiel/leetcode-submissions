class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    private Map<Integer, Integer> islandSizes = new HashMap<>();

    public int largestIsland(int[][] grid) {
        int islandId = 2, maxIslandSize = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    int size = getIslandSize(i, j, grid, islandId);
                    islandSizes.put(islandId++, size);
                    maxIslandSize = Math.max(maxIslandSize, size);
                }
            }
        }

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    Set<Integer> nums = new HashSet<>();
                    for(int[] dir : dirs){
                        int row = i + dir[0], col = j + dir[1];
                        if(row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && grid[row][col] != 0) nums.add(grid[row][col]);
                    }
                    int sum = 1;
                    for(int num : nums) sum+= islandSizes.get(num);
                    maxIslandSize = Math.max(maxIslandSize, sum);
                }
            }
        }
        return maxIslandSize;
    }

    private int getIslandSize(int i, int j, int[][] grid, int islandId){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return 0;
        grid[i][j] = islandId;
        int left = getIslandSize(i, j-1, grid, islandId);
        int right = getIslandSize(i, j+1, grid, islandId);
        int up = getIslandSize(i-1, j, grid, islandId);
        int down = getIslandSize(i+1, j, grid, islandId);
        return left + right + up + down + 1;
    }
}