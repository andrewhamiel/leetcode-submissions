class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE, sum = 0.0;
        for(int right = 0; right < nums.length; right++) {
            sum+= nums[right];
            if(right >= k) sum-= nums[right - k];
            if(right + 1 >= k) result = Math.max(result, sum);
        }
        return result/k;
    }
}