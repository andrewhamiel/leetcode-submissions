class Solution {
    private int target = 0;
    private int totalSum = 0;
    private int[] nums;
    private int[][] memo;
    
    public int findTargetSumWays(int[] nums, int target) {
        //1. Find total
        this.target = target;
        this.nums = nums;
        for(int num : nums) totalSum+= num;

        //2. Make range [-totalSum, totalSum] fit into array with [0, 2 * totalSum]
        memo = new int[nums.length][2 * totalSum + 1];
        for(int[] row : memo) Arrays.fill(row, -1);

        return calculate(0, 0);
    }

    private int calculate(int ind, int sum) {
        //1. Base case
        if(ind == nums.length) return sum == target ? 1 : 0;
        
        //2. Memoization
        if(memo[ind][totalSum + sum] != -1) return memo[ind][totalSum + sum];

        //3. 2 Choices: Add or Subtract
        return memo[ind][totalSum + sum] = calculate(ind + 1, sum + nums[ind]) + calculate(ind + 1, sum - nums[ind]);
    }
}