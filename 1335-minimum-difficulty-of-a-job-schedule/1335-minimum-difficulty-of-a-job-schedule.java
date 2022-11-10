class Solution {
    private int[] jobDifficulty, hardestRemainingJob;
    private int[][] memo;
    private int d = 0;;
    
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.d = d;
        this.jobDifficulty = jobDifficulty;
        if(jobDifficulty.length < d) return -1;
        memo = new int[jobDifficulty.length][d+1];
        for(int[] row : memo) Arrays.fill(row, -1);
        hardestRemainingJob = new int[jobDifficulty.length];
        int hardest = 0;
        for(int i = jobDifficulty.length - 1; i >= 0; i--){
            hardest = Math.max(hardest, jobDifficulty[i]);
            hardestRemainingJob[i] = hardest;
        }
        return dp(0, 1);
    }
    
    private int dp(int i, int day){
        if(day == d) return hardestRemainingJob[i];
        
        if(memo[i][day] == -1){
            int best = Integer.MAX_VALUE, hardest = 0;
            for(int j = i; j < jobDifficulty.length - (d - day); j++){
                hardest = Math.max(hardest, jobDifficulty[j]);
                best = Math.min(best, hardest + dp(j+1, day+1));
            }
            memo[i][day] = best;
        }
        return memo[i][day];
    }
}