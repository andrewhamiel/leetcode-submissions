class Solution {
    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        boolean[][] visit = new boolean[maze.length][maze[0].length];

        Queue<int[]> q = new LinkedList<>();
        q.offer(start);
        visit[start[0]][start[1]] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            if (curr[0] == destination[0] && curr[1] == destination[1]) return true;

            for(int[] dir : dirs){
                int row = curr[0], col  = curr[1];
                while(row >= 0 && row < maze.length && col >= 0 && col < maze[0].length && maze[row][col] == 0){
                    row+= dir[0];
                    col+= dir[1];
                }
                row-= dir[0];
                col-= dir[1];
                if(!visit[row][col]){
                    visit[row][col] = true;
                    q.add(new int[]{row, col});
                }
            }
        }
        return false;
    }
}