class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left)/2;
            //1. Check target
            if(nums[mid] == target) return true;
            //2. Make sure binary search helpful
            if(!isBinarySearchHelpful(left, mid, nums)) {
                left++;
                continue;
            }
            //3. Mid in left Subarray or right subarray
            if(nums[left] < nums[mid]) {
                if(nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            }else{
                if(nums[mid] < target && nums[left] > target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }

    /*
    * If arr[mid] == arr[left], arr[mid] could belone to either subarray and binary search cannot help us find relative position
    */
    private boolean isBinarySearchHelpful(int left, int mid, int[] nums) {
        return nums[left] != nums[mid];
    }
}