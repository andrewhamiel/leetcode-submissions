class Solution {
    Boolean[][] memo;
    int[] nums;

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums) {
            totalSum+= num;
        }    

        if(totalSum % 2 != 0) return false;
        int subsetSum = totalSum/2;
        memo = new Boolean[nums.length + 1][subsetSum + 1];
        this.nums = nums;

        return dfs(nums.length - 1, subsetSum);
    }

    private boolean dfs(int ind, int sum) {
        //Base cases 
        if(sum == 0) return true;
        if(ind < 0 || sum < 0) return false;

        //If already seen
        if(memo[ind][sum] != null) return memo[ind][sum];

        //2 choices: use or do not use 
        return memo[ind][sum] = dfs(ind - 1, sum - nums[ind]) || dfs(ind - 1, sum);
    }
}