class Solution {
    public long findScore(int[] nums) {
        long result = 0;
        //Simulate window size 3 by incrementing by 2
        for(int i = 0; i < nums.length; i+= 2) {
            //Expand sliding window
            int left = i;
            while(i < nums.length - 1 && nums[i] > nums[i + 1]) i++;

            //Simulate marking neighbors by decrementing by 2
            for(int right = i; right >= left; right-= 2) result+= nums[right];
        }
        return result;
    }
}