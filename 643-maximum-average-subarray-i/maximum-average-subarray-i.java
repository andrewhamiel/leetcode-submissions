class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE, sum = 0;
        for(int i = 0; i < nums.length; i++) {
            sum+= nums[i];
            if(i >= k) sum-= nums[i - k];
            if(i >= k - 1) result = Math.max(result, sum);
        }
        return result/k;
    }
}