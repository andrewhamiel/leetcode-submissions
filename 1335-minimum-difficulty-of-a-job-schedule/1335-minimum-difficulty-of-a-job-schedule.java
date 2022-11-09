class Solution {
    //2D DP. Time: O(n^2 * d)
    //Space: O(n*d)
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(d > jobDifficulty.length) return -1;
        
        int[] hardestRemaining = new int[jobDifficulty.length];
        
        int[][] dp = new int[d + 1][jobDifficulty.length + 1];
        for(int day = 0; day <= d; day++){
            for(int j = 0; j < jobDifficulty.length; j++) dp[day][j] = Integer.MAX_VALUE;
        }
        
        for(int daysRemain = 1; daysRemain <= d; daysRemain++){
            for(int i = 0; i < jobDifficulty.length - daysRemain + 1; i++){
                int dailyMaxDiff = 0;
                for(int j = i + 1; j < jobDifficulty.length - daysRemain + 2; j++){
                    dailyMaxDiff = Math.max(dailyMaxDiff, jobDifficulty[j-1]);
                    if(dp[daysRemain-1][j] != Integer.MAX_VALUE){
                        dp[daysRemain][i] = Math.min(dp[daysRemain][i], dailyMaxDiff + dp[daysRemain-1][j]);
                    }
                }
            }
        }
        return dp[d][0] < Integer.MAX_VALUE ? dp[d][0] : -1;
    }
}