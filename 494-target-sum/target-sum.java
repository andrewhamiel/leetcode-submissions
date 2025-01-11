class Solution {
    private int target = 0;
    private int[] nums;
    private int[][] dp;
    private int totalSum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums) {
            totalSum+= num;
        }    

        //Range of possible values is [-totalSum, totalSum]. To make fit in 2D array, make range [0, 2 * totalSum]
        dp = new int[nums.length][2 * totalSum + 1];
        for(int[] row : dp) Arrays.fill(row, -1);

        this.nums = nums;
        this.target = target;

        return calculate(0, 0);
    }

    private int calculate(int ind, int sum) {
        //1. Exit condition
        if(ind == nums.length) return sum == target ? 1 : 0;

        //2. Memoization
        if(dp[ind][totalSum + sum] != -1) return dp[ind][totalSum + sum];

        //2 choices for each num. Add or subtract
        return dp[ind][totalSum + sum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}