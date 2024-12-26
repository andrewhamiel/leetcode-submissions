class Solution {
    public int findMin(int[] nums) {
        if(nums[0] < nums[nums.length - 1]) return nums[0];

        int left = 0, right = nums.length; 
        //[left, right) variant 
        while(left <= right) {
            int mid = left + (right - left)/2;
            if(mid == 0 || nums[mid] < nums[mid - 1]) return nums[mid];
            else if(nums[0] < nums[mid]) left = mid + 1;
            else right = mid;
        }
        return nums[left];
    }
}