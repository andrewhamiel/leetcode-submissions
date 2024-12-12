class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, maxLength = 0, currLength = 0;
        for(int num : nums) {
            if(num > maxVal) {
                maxVal = num;
                maxLength = 0;
                currLength = 0;
            }
            if(num == maxVal) currLength++;
            else currLength = 0;
            
            maxLength = Math.max(maxLength, currLength);
        }
        return maxLength;
    }
}