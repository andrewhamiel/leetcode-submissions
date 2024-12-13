class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int shortestDistance(int[][] grid) {
        int[][] totalSteps = new int[grid.length][grid[0].length];
        int minDistance = Integer.MAX_VALUE, emptyLandValue = 0;
        for(int row = 0; row < grid.length; row++) {
            for(int col = 0; col < grid[0].length; col++) {
                if(grid[row][col] == 1) minDistance = bfs(row, col, grid, totalSteps, emptyLandValue--);
            }
        }
        return minDistance == Integer.MAX_VALUE ? -1 : minDistance;
    }

    private int bfs(int i, int j, int[][] grid, int[][] totalSteps, int emptyLandValue) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{i, j});

        int minDistance = Integer.MAX_VALUE, steps = 1;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] curr = q.poll();
                int row = curr[0], col = curr[1];

                for(int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length 
                        && grid[newRow][newCol] == emptyLandValue) {
                            grid[newRow][newCol]--;
                            totalSteps[newRow][newCol]+= steps;
                            q.add(new int[]{newRow, newCol});
                            minDistance = Math.min(minDistance, totalSteps[newRow][newCol]);
                    }
                }
            }
            steps++;
        }
        return minDistance;
    }
}