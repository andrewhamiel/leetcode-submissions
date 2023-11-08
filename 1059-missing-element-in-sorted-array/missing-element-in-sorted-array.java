class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left + 1)/2;
            if(nums[mid] - nums[0] - mid < k) left = mid;
            else right = mid - 1;
        }
        return nums[0] + k + left;
    }
}