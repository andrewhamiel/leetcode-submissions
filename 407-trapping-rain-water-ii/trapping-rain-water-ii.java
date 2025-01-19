class Solution {
    public int trapRainWater(int[][] heightMap) {
        PriorityQueue<int[]> priQueue = new PriorityQueue<>(
            (a, b) -> heightMap[a[0]][a[1]] - heightMap[b[0]][b[1]]
        );
        int N = heightMap.length, M = heightMap[0].length;
        boolean[][] visited = new boolean[N][M];
        
        // fill top and bottom boundaries
        for(int col = 0; col < M; col++){
            priQueue.add(new int[]{0, col});
            priQueue.add(new int[]{N - 1, col});
            visited[0][col] = true;
            visited[N - 1][col] = true;
        }
        
        // fill left and right boundaries
        for(int row = 0; row < N; row++){
            priQueue.add(new int[]{row, 0});
            priQueue.add(new int[]{row, M - 1});
            visited[row][0] = true;
            visited[row][M - 1] = true;
        }
        
        int totalTrappedWater = 0, max = -1;
        int[][] directions = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
        
        while(!priQueue.isEmpty()){
            int[] curr = priQueue.poll();
            max = Math.max(max, heightMap[curr[0]][curr[1]]);
            totalTrappedWater += max - heightMap[curr[0]][curr[1]];
            
            for(int[] direct : directions){
                int newRow = curr[0] + direct[0];
                int newCol = curr[1] + direct[1];
                
                if(newRow < 0 || newCol < 0 || newRow == N || newCol == M || visited[newRow][newCol]){
                    continue;
                }
                
                priQueue.add(new int[]{newRow, newCol});
                visited[newRow][newCol] = true;
            }
        }
        
        return totalTrappedWater;
    }
}