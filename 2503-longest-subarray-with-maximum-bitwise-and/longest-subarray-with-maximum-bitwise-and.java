class Solution {
    public int longestSubarray(int[] nums) {
        int longest = 0, currLength = 0, maxNum = 0;
        for(int num : nums) {
            if(num > maxNum) {
                maxNum = num;
                longest = currLength = 0;
            }

            if(num == maxNum) currLength++;
            else currLength = 0;

            longest = Math.max(longest, currLength);
        }
        return longest;
    }
}