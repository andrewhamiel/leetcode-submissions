class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(start[0], start[1]));
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<>(start[0], start[1]));

        while(!q.isEmpty()){
            Pair<Integer, Integer> p = q.poll();
            int row = p.getKey(), col = p.getValue();
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

                if(!visited.contains(new Pair<>(newRow, newCol))) {
                    visited.add(new Pair<>(newRow, newCol));
                    q.add(new Pair<>(newRow, newCol));
                }
            }
        }
        return false;
    }
}