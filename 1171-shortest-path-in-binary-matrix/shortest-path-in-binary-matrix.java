class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1) return -1;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 1});
        Set<Pair<Integer, Integer>> visited = new HashSet<>();

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int row = curr[0], col = curr[1], length = curr[2];
            if(row == grid.length - 1 && col == grid[0].length - 1) return length;
            
            for(int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length 
                    && grid[newRow][newCol] == 0 && !visited.contains(new Pair<>(newRow, newCol))) {
                        visited.add(new Pair<>(newRow, newCol));
                        q.add(new int[]{newRow, newCol, length + 1});
                    }
            }
        }
        return -1;
    }
}