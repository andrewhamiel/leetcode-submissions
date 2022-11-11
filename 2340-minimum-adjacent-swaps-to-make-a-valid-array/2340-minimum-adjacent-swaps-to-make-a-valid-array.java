class Solution {
    //Greedy. Time: O(n)
    //Space: O(1)
    public int minimumSwaps(int[] nums) {
        int minIndex = 0, maxIndex = nums.length-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<nums[minIndex]) minIndex =i;
            if(nums[i]>=nums[maxIndex]) maxIndex = i;
        }
        
        if(minIndex==maxIndex) return 0;
        
        int res = minIndex+nums.length-1-maxIndex;
        return minIndex<maxIndex? res:res-1;
    }
}