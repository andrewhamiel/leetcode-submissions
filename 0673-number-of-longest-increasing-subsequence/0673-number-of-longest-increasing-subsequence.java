class Solution {
    public int findNumberOfLIS(int[] nums) {
        int[] dp = new int[nums.length], count = new int[nums.length];
        int ans = Integer.MIN_VALUE, res = 0;
        Arrays.fill(dp, 1);
        Arrays.fill(count, 1);
        for(int i = 0; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]){
                    if(dp[i] < dp[j] + 1){
                        dp[i] = dp[j] + 1;
                        count[i] = count[j];
                    }else if(dp[i] == dp[j] + 1) count[i]+=count[j];
                }
            }
            if(dp[i] > ans){
                ans = dp[i];
                res = count[i];
            }else if(dp[i] == ans) res+=count[i];
        }
        return res;
    }
}