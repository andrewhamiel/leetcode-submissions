class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;

        Queue<Pair<Integer, Integer>> q = new LinkedList<>();
        q.add(new Pair<>(0, 0));
        Set<Pair<Integer, Integer>> visited = new HashSet<>();
        visited.add(new Pair<>(0, 0));

        int length = 1;

        while(!q.isEmpty()) {
            int size = q.size();
            while(size-- > 0) {
                Pair<Integer, Integer> p = q.poll();
                int row = p.getKey(), col = p.getValue();
                if(row == grid.length - 1 && col == grid[0].length - 1) return length;

                for(int[] dir : dirs) {
                    int newRow = row + dir[0], newCol = col + dir[1];
                    if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                        && grid[newRow][newCol] == 0 && !visited.contains(new Pair<>(newRow, newCol))) {
                            visited.add(new Pair<>(newRow, newCol));
                            q.add(new Pair<>(newRow, newCol));
                        }
                }
            }
            length++;
        }
        return -1;
    }
}