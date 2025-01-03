class Solution {
    public int maxSubArray(int[] nums) {
        int currSub = nums[0], maxSub = nums[0];
        for(int i = 1; i < nums.length; i++) {
            currSub = Math.max(nums[i], currSub + nums[i]);
            maxSub = Math.max(maxSub, currSub);
        }
        return maxSub;
    }
}