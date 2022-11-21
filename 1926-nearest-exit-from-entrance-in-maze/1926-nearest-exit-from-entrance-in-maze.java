class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int minPath=Integer.MAX_VALUE;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{entrance[0], entrance[1], 0 });
        int dir[][] = new int[][]{{1,0}, {0,1}, {-1,0}, {0,-1}};
        boolean visited[][] = new boolean[maze.length][maze[0].length];
        visited[entrance[0]][entrance[1]] = true;

        while(!q.isEmpty()){
            int[] c = q.poll();
            for(int d[] : dir){
                int x = d[0] + c[0], y = d[1] + c[1];

                if(x <0 || y <0 || x > maze.length-1 || y > maze[0].length-1 
                   || maze[x][y]!='.' || visited[x][y]) continue;

                q.offer(new int[]{ x, y, c[2]+1});
                visited[x][y] = true;

                if(x == 0 || y ==0 || x == maze.length-1 || y == maze[0].length-1)
                    minPath = Math.min(minPath, c[2]+1);
            }
        }
        return minPath==Integer.MAX_VALUE ? -1 : minPath ;
    }
}