class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
        int firstIndex = lowerBound(nums, target);
        return firstIndex >= 0 && firstIndex + nums.length/2 < nums.length && nums[firstIndex + nums.length/2] == target; 
    }

    private int lowerBound(int[] nums, int target){
        int left = 0, right = nums.length - 1;
        while(left <= right){
            int mid = left + (right - left)/2;
            if(nums[mid] == target && (mid == 0 || nums[mid-1] != target)) return mid;
            else if(nums[mid] >= target) right = mid - 1;
            else left = mid + 1;
        }
        return -1;
    }
}