class Solution {
    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums); //O(nlog(n))
        int w = nums[nums.length - 1] - nums[0], left = 0, right = w;
        //binary search is O(log(w)) with nested O(n) to numOfPairDistancesSmallerThan method
        //Total loop time complexity = O(nlog(w))
        while(left < right){
            int mid = left + (right - left)/2;
            if(numOfPairDistancesSmallerThan(mid, nums) >= k) right = mid;
            else left = mid + 1;
        }
        return left;
    }
    
    //O(n)
    private int numOfPairDistancesSmallerThan(int rangeDist, int[] nums){
        int left = 0, total = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > rangeDist) left++;
            total+=right - left;
        }
        return total;
    }
}