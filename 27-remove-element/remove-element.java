class Solution {
    public int removeElement(int[] nums, int val) {
        int includesVal = 0, excludesVal = 0;
        while(includesVal < nums.length) {
            if(nums[includesVal] == val) includesVal++;
            else swap(excludesVal++, includesVal++, nums);
        }
        return excludesVal;
    }
    
    private void swap(int i, int j, int[] nums) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}