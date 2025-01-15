class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //[left, right] variant
        while(left <= right) {
            int mid = left + (right - left)/2;
            //1. Check mid
            if(nums[mid] == target) return true;
            //2. See if BS will be helpful. If nums[left] == nums[right], cannot determine next partition
            if(nums[left] == nums[mid]) {
                left++;
                continue;
            }
            //3. Find next partition
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
}