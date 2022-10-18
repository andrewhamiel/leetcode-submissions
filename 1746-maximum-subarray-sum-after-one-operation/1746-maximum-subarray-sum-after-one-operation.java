class Solution {
    private final int SQUARED = 0, NOT_SQUARED = 1, NONE_SQUARED = 2;
    
    //3 possible states for each number:
    // 1. square this number
    // 2. do not square this number
    // 3. do not square this number and no other element has been squared
    public int maxSumAfterOperation(int[] nums) {
        int currMax = Integer.MIN_VALUE, max = Integer.MIN_VALUE;
        int [] sum = new int[3];
        int squared = 0, notSquared = 0, noneSquared = 0;
        for(int i = 0; i < nums.length; i++){
            squared = Math.max(0, sum[NONE_SQUARED]) + (nums[i] * nums[i]);
            notSquared = Math.max(sum[SQUARED], Math.max(sum[NOT_SQUARED], sum[NONE_SQUARED])) + nums[i];
            noneSquared = Math.max(0, sum[NONE_SQUARED]) + nums[i];
            currMax = Math.max(squared, Math.max(notSquared, noneSquared));
            max = Math.max(max, currMax);
            
            sum = new int[]{squared, notSquared, noneSquared};
        }
        return max;
    }
}