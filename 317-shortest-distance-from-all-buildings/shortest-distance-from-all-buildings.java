class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int shortestDistance(int[][] grid) {
        int[][] total = new int[grid.length][grid[0].length];
        int minDistance = Integer.MAX_VALUE, emptyLandValue = 0;

        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1) minDistance = bfs(i, j, grid, total, emptyLandValue--);
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int bfs(int i, int j, int[][] grid, int[][] total, int emptyLandValue){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});
        int minDistance = Integer.MAX_VALUE, steps = 0;

        while(!q.isEmpty()){
            steps++;
            int size = q.size();
            while(size-- > 0){
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];
                for(int[] dir : dirs){
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == emptyLandValue){
                            grid[newRow][newCol]--;
                            total[newRow][newCol]+= steps;
                            q.add(new int[]{newRow, newCol});
                            minDistance = Math.min(minDistance, total[newRow][newCol]);
                    }
                }
            }
        }
        return minDistance;
    }
}