class Solution {
    private int[] nums;
    private int target = 0;
    private int totalSum = 0;
    private int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = 0;
        for(int num : nums) totalSum+= num;
        this.totalSum = totalSum;

        this.nums = nums;
        this.target = target;

        //To make range of sums [-totalSum, totalSum] fit into array, make range [2 * targetSum]
        memo = new int[nums.length][2 * totalSum + 1];     
        for(int[] row : memo) Arrays.fill(row, -1);

        return calculate(0, 0);
    }

    private int calculate(int ind, int sum) {
        //1. Base case
        if(ind == nums.length) return sum == target ? 1 : 0;

        //2. Memoization
        if(memo[ind][totalSum + sum] != -1) return memo[ind][totalSum + sum];

        //3. Two choices: Add or subtract
        return memo[ind][totalSum + sum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}