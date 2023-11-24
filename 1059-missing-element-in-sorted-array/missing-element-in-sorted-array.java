class Solution {
    public int missingElement(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        while(left < right){
            int mid = right - (right - left)/2;
            //total number of integers within range [nums[0], nums[mid]] = nums[mid] - nums[0] + 1
            //there are mid + 1 existing elements, so number of missing elements is:
            // (nums[mid] - nums[0] + 1) - (mid + 1) = nums[mid] - nums[0] - mid
            if(nums[mid] - nums[0] - mid < k) left = mid;
            else right = mid - 1;
        }
        //total number of elements in range [nums[0], nums[left]] = left + 1
        //total number of integers in that range, because we have k missing elements = left + 1 + k
        //size of range is answer - nums[0] + 1
        //setting both equal, we have: answer - nums[0] + 1 = left + 1 + k
        //answer = nums[0] + left + k
        return nums[0] + left + k;
    }
}