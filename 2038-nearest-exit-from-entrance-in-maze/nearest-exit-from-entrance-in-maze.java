class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]] = 'e';
        while(!q.isEmpty()){
            int[] entry = q.poll();
            int row = entry[0], col = entry[1], steps = entry[2];
            for(int[] dir : dirs){
                int newRow = row + dir[0], newCol = col + dir[1];
                if(newRow < 0 || newRow >= maze.length || newCol < 0 || newCol >= maze[0].length){
                    if(maze[row][col] != 'e') return steps;
                }
                if(newRow >= 0 && newRow < maze.length && newCol >= 0 && newCol < maze[0].length
                    && maze[newRow][newCol] == '.'){
                        maze[newRow][newCol] = '+';
                        q.add(new int[]{newRow, newCol, steps + 1});
                    }
            }
        }    
        return -1;
    }
}