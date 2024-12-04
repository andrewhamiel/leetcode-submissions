class Solution {
    public void moveZeroes(int[] nums) {
        int zero = 0, nonZero = 0;
        while(nonZero < nums.length) {
            if(nums[nonZero] == 0) nonZero++;
            else swap(zero++, nonZero++, nums);
        }
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}