class Solution {
    public void nextPermutation(int[] nums) {
        int left = nums.length - 2;
        while(left >= 0 && nums[left] >= nums[left + 1]) left--;

        if(left >= 0){
            int right = nums.length - 1;
            while(right > left && nums[right] <= nums[left]) right--;
            swap(left, right, nums);
        }
        reverse(left + 1, nums);
    }

    private void swap(int i, int j, int[] nums){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int left, int[] nums){
        int right = nums.length - 1;
        while(left < right) swap(left++, right--, nums);
    }
}