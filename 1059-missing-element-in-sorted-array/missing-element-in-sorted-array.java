class Solution {
    public int missingElement(int[] nums, int k) {
        //prevent overflow
        int missingNumAmount = nums[nums.length - 1] - nums[0] - (nums.length - 1);
        if(missingNumAmount < k) return nums[nums.length - 1] + k - missingNumAmount;

        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = left + (right - left)/2;
            int missing = nums[mid] - nums[0] - mid;
            if(missing < k) left = mid + 1;
            else right = mid;
        }
        return nums[0] + left + k - 1;
    }
}