class Solution {
    private Integer[][] memo;
    private final int MOD = 1000000007;
    private int k;
    
    public int numRollsToTarget(int n, int k, int target) {
        memo = new Integer[n+1][target+1];
        this.k = k;
        return dp(n, target);
    }
    
    private int dp(int dice, int target){
        if(target < 0) return 0;
        if(dice == 0) return target == 0 ? 1 : 0;
        if(memo[dice][target] != null) return memo[dice][target];
        long ways = 0;
        for(int face = 1; face <= k; face++){
            ways = (ways + dp(dice - 1, target - face)) % MOD;
        }
        memo[dice][target] = (int) ways;
        return memo[dice][target];
    }
}