class Solution {
    public boolean search(int[] nums, int target) {
        if(nums.length == 1) return nums[0] == target;
        int left = 0, right = nums.length - 1;
        //[left, right] variant
        while(left <= right) {
            int mid = left + (right - left)/2;
            //If target found
            if(nums[mid] == target) return true;
            //If nums[left] == nums[mid], impossible to tell if on left or right side
            if(nums[left] == nums[mid]) {
                left++;
                continue;
            }
            //Find next half to search
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