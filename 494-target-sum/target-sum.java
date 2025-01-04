class Solution {
    private int totalSum = 0;
    private int target = 0;
    private int[] nums;
    private int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        //Find totalSum
        for(int num : nums) totalSum+= num;

        this.target = target;
        this.nums = nums;

        //Fit range [-targetSum, targetSum] into array by making it [0, 2 * targetSum]
        memo = new int[nums.length][2 * totalSum + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return calculate(0, 0);    
    }

    private int calculate(int ind, int sum) {
        //1. Base case/Exit condition
        if(ind == nums.length) return sum == target ? 1 : 0;

        //2. Memoization
        if(memo[ind][totalSum + sum] != -1) return memo[ind][totalSum + sum];

        //3. Two choices: Add or Subtract
        return memo[ind][totalSum + sum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}