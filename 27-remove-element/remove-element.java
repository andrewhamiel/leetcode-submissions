class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0, nonK = 0;
        while(nonK < nums.length) {
            if(nums[nonK] == val) nonK++;
            else swap(k++, nonK++, nums);
        }
        return k;
    }

    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}