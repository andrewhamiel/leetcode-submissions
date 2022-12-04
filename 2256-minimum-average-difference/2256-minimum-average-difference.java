class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length, ans = -1, minAvgDiff = Integer.MAX_VALUE;
        long[] prefixSum = new long[n + 1], suffixSum = new long[n + 1];
        
        for (int index = 0; index < n; ++index) prefixSum[index + 1] = prefixSum[index] + nums[index];
                
        for (int index = n - 1; index >= 0; --index) suffixSum[index] = suffixSum[index + 1] + nums[index];
        
        for (int index = 0; index < n; ++index) {
            long leftPartAverage = prefixSum[index + 1];
            leftPartAverage /= (index + 1);
            
            long rightPartAverage = suffixSum[index + 1];
            if (index != n - 1) rightPartAverage /= (n - index - 1);
            
            int currDifference = (int) Math.abs(leftPartAverage - rightPartAverage);
            if (currDifference < minAvgDiff) {
                minAvgDiff = currDifference;
                ans = index;
            }
        }
        
        return ans;
    }
}