class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0, right = 0, currSum = 0;
        double maxAverage = Integer.MIN_VALUE;
        while(right < nums.length) {
            currSum+= nums[right];
            if(right - left + 1 == k) {
                maxAverage = Math.max(maxAverage, (double) currSum / k);
                currSum-= nums[left++];
            }
            right++;
        }
        return maxAverage;
    }
}