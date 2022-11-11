class Solution {
    /*
    *
         * A valid array in this problem means that the smallest element of the array is in the first position and the largest
         * element is in the last position. To solve this problem, we will go through the array and find the positions of the
         * smallest element and the largest element. If the minPos is smaller than the maxPos then we know that it will take
         * minPos swaps to get the smallest element to the beginning and N-1-maxPos swaps for the largest element to be put
         * into the last position. If the maxPos is smaller than the minPos then we return the exact same calculation except
         * we subtract 1 again. We do that because at some point we will swap the min and max elements over each other meaning both
         * of them have moved 1 position closer to their destination in a single operation. Therefore we can reduce our swap count
         * by 1.
    */
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