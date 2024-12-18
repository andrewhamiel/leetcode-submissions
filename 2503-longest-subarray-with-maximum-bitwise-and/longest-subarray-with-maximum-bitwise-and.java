class Solution {
    public int longestSubarray(int[] nums) {
        int longest = 0, currSequence = 0, maxNum = 0;
        for(int num : nums) {
            if(num > maxNum) {
                maxNum = num;
                longest = currSequence = 0;
            }

            if(num == maxNum) currSequence++;
            else currSequence = 0;
            
            longest = Math.max(longest, currSequence);
        }
        return longest;
    }
}