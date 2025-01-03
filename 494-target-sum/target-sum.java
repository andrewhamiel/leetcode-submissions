class Solution {
    private int totalSum = 0;
    private int target = 0;
    private int[] nums;
    private int[][] memo;

    public int findTargetSumWays(int[] nums, int target) {
        for(int num : nums) totalSum+= num;

        this.target = target;
        this.nums = nums;

        //Instead of range [-totalSum, totalSum], we shift to fit in array by adding totalSum to each result making range [0, totalSum]
        memo = new int[nums.length][totalSum * 2 + 1];
        for(int[] row : memo) Arrays.fill(row, Integer.MIN_VALUE);

        return calculate(0, 0);    
    }

    private int calculate(int ind, int sum) {
        //1. Base case
        if(ind == nums.length) return sum == target ? 1 : 0;

        //2. Memoization
        if(memo[ind][sum + totalSum] != Integer.MIN_VALUE) return memo[ind][sum + totalSum];

        //3. 2 Choices: Add or subtract
        return memo[ind][sum + totalSum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}