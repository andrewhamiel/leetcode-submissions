class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for(int k = nums.length - 1; k >= 0; k--) {
            int powLeft = nums[left] * nums[left];
            int powRight = nums[right] * nums[right];
            if(powLeft >= powRight) {
                result[k] = powLeft;
                left++;
            }else {
                result[k] = powRight;
                right--;
            }
        }
        return result;
    }
}