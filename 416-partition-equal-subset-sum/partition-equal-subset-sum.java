class Solution {
    private Boolean[][] memo;
    private int[] nums;

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum+= num;
        }
        
        if(totalSum % 2 != 0) return false;
        int subsetSum = totalSum / 2;
        this.nums = nums;
        memo = new Boolean[nums.length + 1][subsetSum + 1];

        return dp(nums.length - 1, subsetSum);
    }

    private boolean dp(int ind, int currSum) {
        if(currSum == 0) return true;
        if(ind < 0 || currSum < 0) return false;

        if(memo[ind][currSum] != null) return memo[ind][currSum];

        //2 options: use or do not use
        return memo[ind][currSum] = dp(ind - 1, currSum - nums[ind]) || dp(ind - 1, currSum);
    }
}