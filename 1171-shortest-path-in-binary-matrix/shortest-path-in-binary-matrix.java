class Solution {   
    private int[][] dirs = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};
    
    /* A* Approach */
    public int shortestPathBinaryMatrix(int[][] grid) {    
        if (grid[0][0] != 0 || grid[grid.length - 1][grid[0].length - 1] != 0) return -1;
        
        // Set up the A* search. Min Heap
        PriorityQueue<Candidate> minHeap = new PriorityQueue<>((a,b) -> a.totalEstimate - b.totalEstimate);
        minHeap.add(new Candidate(0, 0, 1, estimate(0, 0, grid)));
        
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        
        while (!minHeap.isEmpty()) {    
            Candidate best = minHeap.poll();
            
            // Exit condition
            if (best.row == grid.length - 1 && best.col == grid[0].length - 1) return best.distanceSoFar;
            
            if (visited[best.row][best.col]) continue;
            
            visited[best.row][best.col] = true;
            
            for (int[] neighbor : getNeighbors(best.row, best.col, grid)) {
                int neighborRow = neighbor[0], neighborCol = neighbor[1];
                
                // This check isn't necessary for correctness, but it greatly
                // improves performance.
                if (visited[neighborRow][neighborCol]) continue;
                
                // Otherwise, we need to create a Candidate object for the option
                // of going to neighbor through the current cell.
                int newDistance = best.distanceSoFar + 1;
                int totalEstimate = newDistance + estimate(neighborRow, neighborCol, grid);
                Candidate candidate = new Candidate(neighborRow, neighborCol, newDistance, totalEstimate);
                minHeap.add(candidate);
            }   
        }
        return -1;  
    }
    
    private List<int[]> getNeighbors(int row, int col, int[][] grid) {
        List<int[]> neighbors = new ArrayList<>();
        for (int[] dir : dirs) {
            int newRow = row + dir[0], newCol = col + dir[1];
            if(newRow >=  0 && newRow < grid.length && newCol >= 0 && newCol < grid[0].length
                && grid[newRow][newCol] == 0) {
                    neighbors.add(new int[]{newRow, newCol});
            }
        }
        return neighbors; 
    }
    
    private int estimate(int row, int col, int[][] grid) {
        int remainingRows = grid.length - row - 1;
        int remainingCols = grid[0].length - col - 1;
        return Math.max(remainingRows, remainingCols);
    }

    class Candidate {      
        public int row;
        public int col;
        public int distanceSoFar;
        public int totalEstimate;
        
        public Candidate(int row, int col, int distanceSoFar, int totalEstimate) {
            this.row = row;
            this.col = col;
            this.distanceSoFar = distanceSoFar;
            this.totalEstimate = totalEstimate;
        }
    }
}