class Solution {
    int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int nearestExit(char[][] maze, int[] entrance) {
        int minPath = Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{entrance[0], entrance[1], 0});
        maze[entrance[0]][entrance[1]]= 'e';
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- > 0){
                int[] cell = q.poll();
                int row = cell[0], col = cell[1], steps = cell[2];
                for(int[] dir : dirs){
                    int newRow = dir[0] + row, newCol = dir[1] + col;
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
        }
        return -1;
    }
}