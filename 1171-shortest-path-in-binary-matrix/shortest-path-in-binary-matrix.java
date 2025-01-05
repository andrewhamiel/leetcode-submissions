class Solution {
    private int[][] dirs = new int[][]{{0, -1}, {0, 1}, {-1, 0}, {1, 0}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        //1. Base case
        if(grid[0][0] == 1 || grid[grid.length - 1][grid[0].length - 1] == 1) return -1;

        PriorityQueue<Candidate> minHeap = new PriorityQueue<>((a, b) -> a.totalEstimate - b.totalEstimate);
        minHeap.add(new Candidate(0, 0, 1, getEstimate(0, 0, grid)));
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        //A* traversal
        while(!minHeap.isEmpty()) {
            Candidate best = minHeap.poll();
            int row = best.row, col = best.col;
            //Exit condition
            if(row == grid.length - 1 && col == grid[0].length - 1) return best.currDistance;
            //Memoization
            if(visited[row][col]) continue;
            visited[row][col] = true;

            for(int[] dir : dirs) {
                int newRow = row + dir[0], newCol = col + dir[1];
                if(newRow >= 0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                    && !visited[newRow][newCol] && grid[newRow][newCol] == 0) {
                        int nextDistance = best.currDistance + 1;
                        int totalEstimate = nextDistance + getEstimate(newRow, newCol, grid);
                        minHeap.add(new Candidate(newRow, newCol, nextDistance, totalEstimate));
                }
            }
        }
        return -1;
    }

    private int getEstimate(int row, int col, int[][] grid) {
        int remainingRows = grid.length - row - 1, remainingCols = grid[0].length - col - 1;
        return Math.max(remainingRows, remainingCols);
    }

    class Candidate {
        int row = 0;
        int col = 0;
        int currDistance = 0;
        int totalEstimate = 0;

        public Candidate(int row, int col, int currDistance, int totalEstimate) {
            this.row = row;
            this.col = col;
            this.currDistance = currDistance;
            this.totalEstimate = totalEstimate;
        }
    }
}