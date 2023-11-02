class Solution {
    int[][] dirs = new int[][]{{-1, -1}, {-1, 1}, {1, -1}, {1, 1}, {0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid.length == 0 || grid[0][0] != 0) return -1;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int shortestPath = Integer.MAX_VALUE;
        visited[0][0] = true;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        int steps = 0;
        while(!q.isEmpty()){
            int size = q.size();
            steps++;
            while(size-- > 0){
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];
                if(row == grid.length - 1 && col == grid[0].length - 1 && grid[row][col] == 0) return steps;
                for(int[] dir : dirs){
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length 
                        && !visited[newRow][newCol] && grid[newRow][newCol] == 0){
                            visited[newRow][newCol] = true;
                            q.add(new int[]{newRow, newCol});
                        }
                }
            }
        }
        return -1;
    }
}