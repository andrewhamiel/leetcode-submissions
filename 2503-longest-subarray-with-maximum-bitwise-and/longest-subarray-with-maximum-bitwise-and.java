class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, currStreak = 0, result = 0;
        
        for(int num : nums) {
            if(num > maxVal) {
                maxVal = num;
                result = currStreak = 0;
            }

            if(num == maxVal) currStreak++;
            else currStreak = 0;

            result = Math.max(result, currStreak);
        }
        return result;
    }
}