class Solution {
    private int[] nums;
    private int target = 0;
    private int[][] memo;
    private int totalSum = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums) {
            totalSum+= num;
        }

        this.nums = nums;
        this.target = target;

        //Make range [0, 2 * totalSum] to fit in 2D matrix
        memo = new int[nums.length][2 * totalSum + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return calculate(0, 0);
    }

    private int calculate(int ind, int sum) {
        //1. Exit condition
        if(ind == nums.length) return sum == target ? 1 : 0;

        //2. Memoization
        if(memo[ind][totalSum + sum] != -1) return memo[ind][totalSum + sum];

        //3. Two choices for each num: add or subtract
        return memo[ind][totalSum + sum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}