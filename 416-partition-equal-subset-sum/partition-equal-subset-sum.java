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

    private boolean dp(int ind, int sum) {
        if(sum == 0) return true;
        if(ind < 0 || sum < 0) return false;

        if(memo[ind][sum] != null) return memo[ind][sum];

        //2 options: use or do not use 
        return memo[ind][sum] = dp(ind - 1, sum - nums[ind]) || dp(ind - 1, sum);
    }
}