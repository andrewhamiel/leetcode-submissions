class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target;

        int left = 0, right = nums.length - 1;
        //[left, right] variant
        while(left <= right) {
            int mid = left + (right - left)/2;
            //1. Check mid
            if(nums[mid] == target) return true;
            //2. See if BS helpful. If nums[left] == nums[mid], cannot tell which partition to go to next
            if(nums[left] == nums[mid]) {
                left++;
                continue;
            }
            //3. Find next partition
            if(nums[left] < nums[mid]) {
                if(nums[mid] > target && nums[left] <= target) right = mid - 1;
                else left = mid + 1;
            }else {
                if(nums[left] > target && nums[mid] < target) left = mid + 1;
                else right = mid - 1;
            }
        }
        return false;
    }
}