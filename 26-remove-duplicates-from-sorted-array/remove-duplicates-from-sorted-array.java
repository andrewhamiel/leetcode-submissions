class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0) return 0;
        int left = 0, right = 1;
        while(right < nums.length){
            if(nums[right] != nums[left]){
                left++;
                nums[left] = nums[right];
            }
            right++;
        }
        return left + 1;
    }
}