class Solution {
    public int wiggleMaxLength(int[] nums) {
        if(nums.length == 1) return 1;
        int[] up = new int[nums.length], down = new int[nums.length];
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[i] > nums[j]) up[i] = Math.max(up[i], down[j] + 1);
                else if(nums[j] > nums[i]) down[i] = Math.max(down[i], up[j] + 1);
            }
        }
        return 1 + Math.max(up[nums.length - 1], down[nums.length - 1]);
    }
}