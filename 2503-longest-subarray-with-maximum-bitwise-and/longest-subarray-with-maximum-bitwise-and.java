class Solution {
    public int longestSubarray(int[] nums) {
        int longestSequence = 0, maxNum = 0, currSequence = 0;
        for(int num : nums) {
            if(num > maxNum) {
                maxNum = num;
                longestSequence = currSequence = 0;
            }

            if(num == maxNum) currSequence++;
            else currSequence = 0;

            longestSequence = Math.max(longestSequence, currSequence);
        }
        return longestSequence;
    }
}