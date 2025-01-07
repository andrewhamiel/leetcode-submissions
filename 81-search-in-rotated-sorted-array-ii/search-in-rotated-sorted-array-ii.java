class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //[left, right] variant
        while(left <= right) {
            int mid = left + (right - left)/2;
            //1. Check target
            if(nums[mid] == target) return true;
            //2. Make sure binary search helpful
            if(!isBinarySearchHelpful(left, mid, nums)) {
                left++;
                continue;
            }
            //3. Mid in left or right subarray
            if(nums[left] < nums[mid]) {
                if(nums[left] <= target && nums[mid] > target) right = mid - 1;
                else left = mid + 1;
            }else {
                if(nums[left] > target && nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    /*
    * If nums[left] == nums[mid], cannot determine if mid is in left or right subarray
    */
    private boolean isBinarySearchHelpful(int left, int mid, int[] nums) {
        return nums[left] != nums[mid];
    }
}