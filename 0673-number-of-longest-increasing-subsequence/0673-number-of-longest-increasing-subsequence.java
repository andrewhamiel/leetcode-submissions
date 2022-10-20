class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp  = new int[nums.length], count = new int[nums.length];
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[i] == dp[j] + 1){
                        count[i]+=count[j];
                    }
                }
                
            }
            ans = Math.max(ans, dp[i]);
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++) if(dp[i] == ans) res+=count[i];
        return res;
    }
}