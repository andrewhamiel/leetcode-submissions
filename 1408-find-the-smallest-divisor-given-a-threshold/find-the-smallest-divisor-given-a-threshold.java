class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        long sum = 0;
        for(int num : nums) sum+= num;

        long left = 1, right = sum;
        while(left < right){
            long mid = left + (right - left)/2;
            long currSum = 0;
            for(int num : nums){
                currSum+= Math.ceil((double)num/mid);
            }
            if(currSum <= threshold) right = mid;
            else left = mid + 1;
        }
        return (int)right;
    }
}