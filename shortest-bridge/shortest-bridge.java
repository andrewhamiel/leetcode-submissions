class Solution {
    Queue<int[]> q = new LinkedList<>();
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int shortestBridge(int[][] grid) {
        boolean flag = false;
        for(int i = 0; i < grid.length && !flag; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1){
                    dfs(i, j, grid);
                    flag = true;
                    break;
                }
            }
        }

        while(!q.isEmpty()){
            int[] pos = q.poll();
            for(int[] dir : dirs){
                int x = pos[0] + dir[0], y = pos[1] + dir[1];
                if(x >= 0 && x < grid.length && y >= 0 && y < grid[0].length){
                    if(grid[x][y] == 1) return pos[2];
                    if(grid[x][y] == 0){
                        q.add(new int[]{x, y, pos[2] + 1});
                        grid[x][y] = 2;
                    }
                }
            }
        }
        return -1;
    }
    
    private void dfs(int i, int j, int[][] grid){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length || grid[i][j] != 1) return;
        grid[i][j] = 2;
        q.add(new int[]{i, j, 0});
        dfs(i, j-1, grid);
        dfs(i, j+1, grid);
        dfs(i-1, j, grid);
        dfs(i+1, j, grid);
    }
}