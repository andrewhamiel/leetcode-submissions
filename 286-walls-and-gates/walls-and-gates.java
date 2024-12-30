class Solution {
    private static final int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public void wallsAndGates(int[][] rooms) {
        //1. Find all gates
        Queue<int[]> q = new LinkedList<>();
        for(int row = 0; row < rooms.length; row++) {
            for(int col = 0; col < rooms[0].length; col++) {
                if(rooms[row][col] == 0) q.add(new int[]{row, col});
            }
        }
        //2. BFS from gates
        int moves = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                int[] cell = q.poll();
                int row = cell[0], col = cell[1];

                for(int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if(newRow >= 0 && newRow < rooms.length && newCol >= 0 && newCol < rooms[0].length
                        && rooms[newRow][newCol] == Integer.MAX_VALUE) {
                            rooms[newRow][newCol] = moves;
                            q.add(new int[]{newRow, newCol});
                    }
                }
            }
            moves++;
        }
    }
}