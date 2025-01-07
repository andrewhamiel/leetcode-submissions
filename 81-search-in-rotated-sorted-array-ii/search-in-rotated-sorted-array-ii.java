class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //[left ,right] variant
        while(left <= right) {
            int mid = left + (right - left)/2;
            //1. Check target
            if(nums[mid] == target) return true;
            //2. Make sure binary search helpful
            if(!isBinarySearchHelpful(left, mid, nums)) {
                left++;
                continue;
            }
            //3. Mid in left subarray or right subarray
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
    * If nums[left] == nums[mid], mid could be in either subarray so not helpful to use binary search
    */
    private boolean isBinarySearchHelpful(int left, int mid, int[] nums) {
        return nums[left] != nums[mid];
    }
}