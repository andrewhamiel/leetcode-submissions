class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int t0 = nums[0], t1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++) {
            int tmp = Math.max(t0 + nums[i], t1);
            t0 = t1;
            t1 = tmp;
        }
        return Math.max(t0, t1);
    }
}