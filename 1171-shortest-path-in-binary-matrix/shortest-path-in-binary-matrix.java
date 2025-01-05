class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        //Key intuition: Shortest Path -> BFS good option
        //1. Base case
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;

        //2. Create our Queue and initial state
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        visited[0][0] = true;

        int moves = 1;

        //3. BFS
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];
                //Exit condition
                if(row == grid.length - 1 && col == grid[0].length - 1) return moves;

                for(int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    //Want to see if this is valid, unvisited next node to traverse
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                            visited[newRow][newCol] = true; //Only visit once
                            q.add(new int[]{newRow, newCol});
                        }
                }
            }
            moves++;
        }
        return -1;
    }
}