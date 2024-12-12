class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, result = 0;
        for(int right = 0; right < nums.length; right++) {
            if(nums[right] == 0) k--;
            if(k < 0 && nums[left++] == 0) k++;
            if(k >= 0) result = Math.max(result, right - left + 1);
        }
        return result;
    }
}