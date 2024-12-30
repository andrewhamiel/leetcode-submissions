class Solution {
    public int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int left = 0, right = nums.length - 1;
        for(int i = nums.length - 1; i >= 0; i--) {
            int powLeft = nums[left] * nums[left], powRight = nums[right] * nums[right];
            if(powLeft >= powRight) {
                result[i] = powLeft;
                left++;
            }else {
                result[i] = powRight;
                right--;
            }
        }
        return result;
    }
}