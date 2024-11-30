class Solution {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i + 1]) i--;

        if(i >= 0) {
            int j = nums.length - 1;
            while(j > 0 && nums[i] >= nums[j]) j--;
            swap(i, j, nums);
        }
        reverse(i + 1, nums);
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int left, int[] nums) {
        int right = nums.length - 1;
        while(left < right) swap(left++, right--, nums);
    }
}