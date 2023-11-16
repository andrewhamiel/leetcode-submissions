class Solution {
    public void moveZeroes(int[] nums) {
        int left = 0, right = 0;
        while(right < nums.length){
            if(nums[right] != 0) swap(left++, right++, nums);
            else right++;
        }
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}