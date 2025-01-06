class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1; //Will calculate mid + 1 in search space
        //[left, right) variant
        while(left < right) {
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}