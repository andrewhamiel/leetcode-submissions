class Solution {
    //Binary Search + Sliding Window. n = nums.length, w = Math.max(nums[i])
    //Time: O(nlog(n) + nlog(w))
    //nlog(n) from Arrays.sort
    //binary search is O(log(w)), sliding window is O(n)
    //Space: O(1)
    public int smallestDistancePair(int[] nums, int k) {
        //sort the array & initialize variable
        Arrays.sort(nums); //O(nlog(n))
        int w = nums[nums.length - 1] - nums[0], left = 0, right = w;
        //O(n*log(w))
        while(left < right){
            int mid = left + (right - left)/2;
            if(numPairsWithDistanceLessThanOrEqualTo(nums, mid) >= k) right = mid; //O(n)
            else left = mid + 1;
        }
        return left;
    }
    
    
    //simple sliding window
    //remember this is sorted array
    private int numPairsWithDistanceLessThanOrEqualTo(int [] nums, int mid){
        int left = 0, total = 0;
        for(int right = 0; right < nums.length; right++){
            while(nums[right] - nums[left] > mid) left++;
            total+=right - left;
        }
        return total;
    }
}