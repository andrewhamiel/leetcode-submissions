class Solution {
    private int totalSum = 0;
    private int[][] memo;
    private int[] nums;
    private int target = 0;

    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums) totalSum+= num;

        //Instead of [-totalSum, totalSum], we shift range by adding totalSum to lower and upper bounds
        memo = new int[nums.length][2 * totalSum + 1];
        for(int[] row : memo) Arrays.fill(row, Integer.MIN_VALUE);

        this.nums = nums;
        this.target = target;

        return calculate(0, 0);
    }

    private int calculate(int ind, int sum) {
        //1. Base case
        if(ind == nums.length) return sum == target ? 1 : 0;

        //2. Memoization
        if(memo[ind][sum + totalSum] != Integer.MIN_VALUE) return memo[ind][sum + totalSum];

        //3. 2 choices: add or subtract
        return memo[ind][sum + totalSum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}