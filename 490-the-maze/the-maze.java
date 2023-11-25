class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        Queue<int[]> q = new LinkedList<>();
        q.add(start);
        visited[start[0]][start[1]] = true;

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0], col = curr[1];
            if(row == destination[0] && col == destination[1]) return true;
            for(int[] dir : dirs){
                int newRow = row + dir[0], newCol = col + dir[1];
                while(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length
                    && maze[newRow][newCol] == 0){
                        newRow+= dir[0];
                        newCol+= dir[1];
                }
                newRow-= dir[0];
                newCol-= dir[1];
                if(!visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    q.add(new int[]{newRow, newCol});
                }
            }
        }
        return false;
    }
}