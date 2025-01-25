class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0, nonZero = 0;
        while(zero < nums.length) {
            if(nums[zero] == 0) zero++;
            else swap(nonZero++, zero++, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}