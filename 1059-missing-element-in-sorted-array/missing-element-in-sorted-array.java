class Solution {
    public int missingElement(int[] nums, int k) {
        //prevent overflow
        int missingNumAmt = nums[nums.length - 1] - nums[0] - (nums.length-1);
        if (missingNumAmt < k) return nums[nums.length - 1] + k - missingNumAmt;

        int left = 0 , right = nums.length - 1;  
        while(left<right) {
            int mid = left + (right-left)/2;
            int missing = nums[mid]-nums[0]-mid;
            if(missing < k) left = mid+1;
            else right = mid;
        }
        return nums[0] + left + k - 1;
    }
}