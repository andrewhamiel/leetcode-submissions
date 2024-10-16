class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int left = 0, currSum = 0, prefixZeroes = 0, totalCount = 0;

        for(int right = 0; right < nums.length; right++) {
            currSum+= nums[right];

            while(left < right && (nums[left] == 0 || currSum > goal)){
                if(nums[left] == 0) prefixZeroes++;
                else prefixZeroes = 0;

                currSum-= nums[left++];
            }

            if(currSum == goal) totalCount+= 1 + prefixZeroes;
        }
        return totalCount;
    }
}