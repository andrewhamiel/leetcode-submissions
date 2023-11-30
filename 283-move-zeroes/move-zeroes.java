class Solution {
    public void moveZeroes(int[] nums) {
        int lastZero = 0, lastNonZero = 0;
        while(lastNonZero < nums.length){
            if(nums[lastNonZero] == 0) lastNonZero++;
            else swap(lastZero++, lastNonZero++, nums);
        }
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}