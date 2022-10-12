class Solution {
    public int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int largestPerim = 0;
        for(int i = 2; i < nums.length; i++){
            if(nums[i-2] + nums[i-1] > nums[i]) largestPerim = nums[i] + nums[i-1] + nums[i-2];
        }
        return largestPerim;
    }
}