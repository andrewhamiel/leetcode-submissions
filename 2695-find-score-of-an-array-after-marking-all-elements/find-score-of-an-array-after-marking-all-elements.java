class Solution {
    public long findScore(int[] nums) {
        long result = 0;
        //Simulate window size 3 by incrementing by 2
        for(int i = 0; i < nums.length; i+= 2) {
            //Find local minima
            int left = i;
            while(i + 1 < nums.length && nums[i + 1] < nums[i]) i++;

            //Simulate marking elements by decrementing window size by 2
            for(int right = i; right >= left; right-= 2) result+= nums[right];
        }
        return result;
    }
}