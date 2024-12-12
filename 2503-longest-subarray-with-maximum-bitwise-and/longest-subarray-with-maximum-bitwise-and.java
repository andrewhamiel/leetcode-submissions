class Solution {
    public int longestSubarray(int[] nums) {
        int maxVal = 0, currLength = 0, result = 0;
        for(int num : nums) {
            if(num > maxVal) {
                maxVal = num;
                currLength = 0;
                result = 0;
            }

            if(num == maxVal) currLength++;
            else currLength = 0;

            result = Math.max(result, currLength);
        }
        return result;
    }
}