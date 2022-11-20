class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        int w = nums[nums.length - 1], left = 0, right = w;
        while(left < right){
            int mid = left + (right - left)/2;
            if(numOfPairDistancesSmallerThan(mid, nums) >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    private int numOfPairDistancesSmallerThan(int rangeDist, int[] nums){
        int left = 0, total = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > rangeDist) left++;
            total+= right - left;
        }
        return total;
    }
}