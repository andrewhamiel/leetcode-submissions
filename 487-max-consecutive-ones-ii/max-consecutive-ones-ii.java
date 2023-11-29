class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int[][] dp = new int[nums.length+1][2];
        for(int i = nums.length - 1; i >= 0; i--){
            if(nums[i] == 1){
                dp[i][0] = 1 + dp[i+1][0];
                dp[i][1] = 1 + dp[i+1][1];
                max = Math.max(max, dp[i][1]);
            }else{
                dp[i][0] = 0;
                int tmp = 1 + dp[i+1][0];
                max = Math.max(max, Math.max(dp[i+1][1], tmp));
                dp[i][1] = tmp;
            }
        }
        return max;
    }
}