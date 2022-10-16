class Solution {
    private int d;
    private int[][] memo;
    private int[] jobDifficulty;
    private int[] hardestJobRemaining;  
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        // If we cannot schedule at least one job per day, 
        // it is impossible to create a schedule
        if (jobDifficulty.length < d) return -1;
        
        hardestJobRemaining = new int[jobDifficulty.length];
        int hardestJob = 0;
        for (int i = jobDifficulty.length - 1; i >= 0; i--) {
            hardestJob = Math.max(hardestJob, jobDifficulty[i]);
            hardestJobRemaining[i] = hardestJob;
        }
        // Initialize memo array with value of -1.
        memo = new int[jobDifficulty.length][d + 1];
        for (int i = 0; i < jobDifficulty.length; i++) Arrays.fill(memo[i], -1);
        
        this.d = d;
        this.jobDifficulty = jobDifficulty;
        return dp(0, 1);
    }
    
    private int dp(int i, int day) {
        // Base case, it's the last day so we need to finish all the jobs
        if (day == d) return hardestJobRemaining[i];
        
        if (memo[i][day] == -1) {
            int best = Integer.MAX_VALUE, hardest = 0;
            // Iterate through the options and choose the best
            for (int j = i; j < jobDifficulty.length - (d - day); j++) {
                hardest = Math.max(hardest, jobDifficulty[j]);
                // Recurrence relation
                best = Math.min(best, hardest + dp(j + 1, day + 1));
            }
            memo[i][day] = best;
        }       
        return memo[i][day];
    }
}