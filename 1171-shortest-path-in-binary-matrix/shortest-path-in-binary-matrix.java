class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        grid[0][0] = 1;

        int pathLength = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];
                if(row == grid.length - 1 && col == grid[0].length - 1) return pathLength;

                for(int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length 
                        && grid[newRow][newCol] == 0) {
                            grid[newRow][newCol] = 1;
                            q.add(new int[]{newRow, newCol});
                    }
                }
            }       
            pathLength++;
        }
        return -1;
    }
}