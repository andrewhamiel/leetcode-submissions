class Solution {
    private int[][] memo;
    private int totalSum = 0;
    private int target = 0;
    private int[] nums;

    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums) {
            totalSum+= num;
        }    

        this.nums = nums;
        this.target = target;

        //Range of values is [-totalSum, totalSum]. To make compatible with array, make range [0, 2 * totalSum]
        memo = new int[nums.length][2 * totalSum + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return calculate(0, 0);
    }

    private int calculate(int ind, int sum) {
        //1. Base case
        if(ind == nums.length) return sum == target ? 1 : 0;

        //2. Memoization
        if(memo[ind][totalSum + sum] != -1) return memo[ind][totalSum + sum];

        //3. For each num, two choices: Add or Subtract
        return memo[ind][totalSum + sum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}