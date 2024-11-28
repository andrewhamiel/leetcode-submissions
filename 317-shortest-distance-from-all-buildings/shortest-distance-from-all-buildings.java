class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int shortestDistance(int[][] grid) {
        int minDistance = Integer.MAX_VALUE, emptyLandValue = 0;
        int[][] total = new int[grid.length][grid[0].length];
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) minDistance = bfs(row, col, grid, total, emptyLandValue--);
            }
        }    
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int bfs(int i, int j, int[][] grid, int[][] total, int emptyLandValue) {
        int steps = 1, minDistance = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];

                for(int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == emptyLandValue) {
                            grid[newRow][newCol]--;
                            total[newRow][newCol]+= steps;
                            q.add(new int[]{newRow, newCol});
                            minDistance = Math.min(minDistance, total[newRow][newCol]);
                        }
                }
            }
            steps++;
        }
        return minDistance;
    }
}