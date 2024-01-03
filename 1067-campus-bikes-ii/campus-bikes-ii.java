class Solution {
    int memo [] = new int[1024];

    public int assignBikes(int[][] workers, int[][] bikes) {
        Arrays.fill(memo, -1);
        return minimumDistanceSum(workers, bikes, 0, 0);
    }
      
    private int minimumDistanceSum(int[][] workers, int[][] bikes, int workerIndex, int mask) {
        if (workerIndex >= workers.length) return 0;
        
        if (memo[mask] != -1) return memo[mask];
        
        int smallestDistanceSum = Integer.MAX_VALUE;
        for (int bikeIndex = 0; bikeIndex < bikes.length; bikeIndex++) {
            if ((mask & (1 << bikeIndex)) == 0) {
                smallestDistanceSum = Math.min(smallestDistanceSum, 
                                               findDistance(workers[workerIndex], bikes[bikeIndex]) + 
                                               minimumDistanceSum(workers, bikes, workerIndex + 1, 
                                                                  mask | (1 << bikeIndex)));
            }
        }  
        return memo[mask] = smallestDistanceSum;
    }
    
    private int findDistance(int[] worker, int[] bike) {
        return Math.abs(worker[0] - bike[0]) + Math.abs(worker[1] - bike[1]);
    }
 
}