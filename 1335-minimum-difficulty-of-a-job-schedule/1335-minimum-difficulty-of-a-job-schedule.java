class Solution {
    int d = 0;
    int[] hardestJobRemaining, jobDifficulty;
    int[][] memo;
    public int minDifficulty(int[] jobDifficulty, int d) {
        this.d = d;
        this.jobDifficulty = jobDifficulty;
        //base case
        if(d > jobDifficulty.length) return -1;
        //find most difficult job remaining
        hardestJobRemaining = new int[jobDifficulty.length];
        int hardest = 0;
        for(int i = jobDifficulty.length - 1; i >= 0; i--){
            hardest = Math.max(hardest, jobDifficulty[i]);
            hardestJobRemaining[i] = hardest;
        }
        //create memo
        memo = new int[jobDifficulty.length][d+1];
        for(int[] row : memo) Arrays.fill(row, -1);
        //find min
        return dp(0, 1);
    }
    
    private int dp(int i, int day){
        if(day == d) return hardestJobRemaining[i];
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