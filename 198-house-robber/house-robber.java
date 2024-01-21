class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return Math.max(nums[0], nums[1]);
        int t2 = nums[0], t1 = Math.max(nums[0], nums[1]);
        for(int i = 2; i < nums.length; i++){
            int tmp = Math.max(t2 + nums[i], t1);
            t2 = t1;
            t1 = tmp;
        }
        return t1;
    }
}