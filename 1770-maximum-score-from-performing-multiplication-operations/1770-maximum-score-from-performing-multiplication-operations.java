class Solution {
    private int[][] memo;
    private int[] mult;
    private int[] nums;
    
    public int maximumScore(int[] nums, int[] multipliers) {
        this.nums = nums;
        mult = multipliers;
        memo = new int[multipliers.length][multipliers.length];
        return dp(0, 0);
    }
    
    private int dp(int i, int left){
        if(i == mult.length) return 0;
        int mul = mult[i], right = nums.length - 1 - (i-left);
        if(memo[i][left] == 0){
            memo[i][left] = Math.max(nums[left] * mul + dp(i+1, left+1),
                                     nums[right] * mul + dp(i+1, left));
        }
        return memo[i][left];
    }
}